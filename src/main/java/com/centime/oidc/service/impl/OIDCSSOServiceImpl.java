package com.centime.oidc.service.impl;

import com.centime.logging.CentimeLogger;
import com.centime.model.common.User;
import com.centime.oidc.config.AWSCognitoConfig;
import com.centime.oidc.response.CognitoToken;
import com.centime.oidc.service.OIDCSSOService;
import com.centime.util.CentimeJwtParserUtil;
import com.centime.util.CentimeRestTemplate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * OIDC SSO Service Implementation
 */
@Service
public class OIDCSSOServiceImpl implements OIDCSSOService {

  private static final CentimeLogger log = CentimeLogger.getLogger();

  @Autowired
  protected AWSCognitoConfig awsCognitoConfig;

  @Autowired
  private final CentimeRestTemplate restTemplate; // Rest template to make API calls

  private final ObjectMapper mapper; // Object mapper to map request/response

  public OIDCSSOServiceImpl(CentimeRestTemplate restTemplate, ObjectMapper mapper) {
    this.restTemplate = restTemplate;
    this.mapper = mapper;
  }

  public User getUserSession(String AuthCode) {

    CognitoToken cognitoToken = null;
    try {
      HttpHeaders headers = new HttpHeaders();
      headers.add("Content-Type", awsCognitoConfig.getHeaderContentType());
      headers.add("Authorization", awsCognitoConfig.getAuthorization());

      MultiValueMap<String, String> map = new LinkedMultiValueMap<>();

      map.add("grant_type", awsCognitoConfig.getGrantType());
      map.add("client_id", awsCognitoConfig.getPoolAppId());
      map.add("code", AuthCode);
      map.add("redirect_uri", awsCognitoConfig.getRedirectURI());

      HttpEntity<MultiValueMap<String, String>> formEntity = new HttpEntity<>(map, headers);

      cognitoToken = mapper.readValue(restTemplate.restTemplate()
          .exchange(awsCognitoConfig.getPoolBaseURL() + awsCognitoConfig.getTokenURL(),
              HttpMethod.POST, formEntity, String.class)
          .getBody(), CognitoToken.class);
    } catch (JsonProcessingException e) {
      log.error("JsonProcessingException occurred" + e.getMessage(), e);
    }

    return populateUserFromCognitoToken(cognitoToken);
  }

  private User populateUserFromCognitoToken(CognitoToken cognitoToken) {

    if (cognitoToken == null)
      return null;

    User user = new User();

    try {

      JsonObject header = CentimeJwtParserUtil.getHeader(cognitoToken.getIdToken());
      log.debug("Header Algo: " + header.get("alg"));

      JsonObject payload = CentimeJwtParserUtil.getPayload(cognitoToken.getIdToken());
      log.debug("Payload: " + payload.getAsJsonObject().toString());

      log.debug("Payload: sub: " + payload.get("sub"));
      log.debug("Payload: cognito:username: " + payload.get("cognito:username"));
      log.debug("Payload: email: " + payload.get("email"));

      user.setRefreshToken(cognitoToken.getRefreshToken());
      user.setAccessToken(cognitoToken.getAccessToken());
      user.setLoginId(payload.get("email").getAsString());
      user.setLastName(payload.get("family_name").getAsString());
      user.setFirstName(payload.get("given_name").getAsString());

    } catch (Exception e) {
      log.error("Exception occured at populateUserFromCognitoToken" + e.getMessage(), e);
    }

    return user;

  }
}
