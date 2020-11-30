package com.centime.oidc.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import com.centime.controller.BaseController;
import com.centime.enums.StatusEnum;
import com.centime.exception.CentimeDataServiceException;
import com.centime.logging.CentimeLogger;
import com.centime.model.common.Response;
import com.centime.oidc.constants.EndpointConstants;
import com.centime.oidc.service.OIDCSSOService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
//import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
//import org.springframework.security.oauth2.core.oidc.user.OidcUser;
//import org.springframework.web.bind.annotation.ResponseBody;
//

@RestController
@RequestMapping(EndpointConstants.BASE_V1_API)
public class OIDCController extends BaseController {
  private static final CentimeLogger log = CentimeLogger.getLogger();

  @Autowired
  protected OIDCSSOService oidcssoService;
  // @RequestMapping("/user/login")
  // @ResponseBody
  // public String home(HttpServletRequest request, @AuthenticationPrincipal OidcUser oidcUser,
  // @RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient) {
  //
  // log.debug("OIDC User Full Name: " + oidcUser.getFullName());
  //
  // StringBuffer buffer = new StringBuffer();
  // buffer.append(" Welcome, " + oidcUser.getFullName() + " \n\n");
  // buffer.append("Your Received Attributes: " + oidcUser.getAttributes().toString() + " \n\n");
  // buffer.append(
  // "Your Received Scopes/Authorities : " + oidcUser.getAuthorities().toString() + " \n\n");
  //
  // buffer.append("Access Token Hash: " + oidcUser.getAccessTokenHash() + " \n\n");
  // buffer.append("Authorization Code Hash: " + oidcUser.getAuthorizationCodeHash() + " \n\n");
  // buffer.append("Id Token : " + oidcUser.getIdToken().getTokenValue() + " \n\n");
  // buffer.append("User Info : " + oidcUser.getUserInfo() + " \n\n");
  //
  // if (authorizedClient == null)
  // log.debug("authorizedClient is null");
  // else {
  // buffer.append("Access Token Value:" + authorizedClient.getAccessToken().getTokenValue());
  // buffer.append("Access Token Expires At:" + authorizedClient.getAccessToken().getExpiresAt());
  // buffer.append(
  // "Access Token Scopes :" + authorizedClient.getAccessToken().getScopes().toString());
  // buffer.append(
  // "Access Token Type :" + authorizedClient.getAccessToken().getTokenType().getValue());
  //
  // buffer.append("Refresh Token Value:" + authorizedClient.getRefreshToken().getTokenValue());
  // }
  // return buffer.toString();
  // }
  //
  // @GetMapping("/private")
  // public String redirectToRoot(HttpServletRequest request,
  // @AuthenticationPrincipal OidcUser oidcUser,
  // @RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient) {
  //
  // log.debug("OIDC User Full Name: " + oidcUser.getFullName());
  //
  // StringBuffer buffer = new StringBuffer();
  // buffer.append(" Welcome, " + oidcUser.getFullName() + " \n\n");
  // buffer.append("Your Received Attributes: " + oidcUser.getAttributes().toString() + " \n\n");
  // buffer.append(
  // "Your Received Scopes/Authorities : " + oidcUser.getAuthorities().toString() + " \n\n");
  //
  // buffer.append("Access Token Hash: " + oidcUser.getAccessTokenHash() + " \n\n");
  // buffer.append("Authorization Code Hash: " + oidcUser.getAuthorizationCodeHash() + " \n\n");
  // buffer.append("Id Token : " + oidcUser.getIdToken().getTokenValue() + " \n\n");
  // buffer.append("User Info : " + oidcUser.getUserInfo() + " \n\n");
  //
  // if (authorizedClient == null)
  // log.debug("authorizedClient is null");
  // else {
  // buffer.append("Access Token Value:" + authorizedClient.getAccessToken().getTokenValue());
  // buffer.append("Access Token Expires At:" + authorizedClient.getAccessToken().getExpiresAt());
  // buffer.append(
  // "Access Token Scopes :" + authorizedClient.getAccessToken().getScopes().toString());
  // buffer.append(
  // "Access Token Type :" + authorizedClient.getAccessToken().getTokenType().getValue());
  //
  // buffer.append("Refresh Token Value:" + authorizedClient.getRefreshToken().getTokenValue());
  // }
  // log.debug("User Details: \n\n" + buffer.toString());
  // return "redirect:/localhost:3000/dashboard";
  // }

  @GetMapping("/oidc-sso-redirect")
  public Object redirectToRoot(HttpServletRequest request) throws CentimeDataServiceException {

    log.debug(" HTTTP Request Received: \n " + httpServletRequestToString(request));
    String authCode = request.getParameter("code");

    return new ResponseEntity<>(generateSuccessResponse(oidcssoService.getUserSession(authCode)),
        HttpStatus.OK);
  }
  public static <T> Response<T> generateSuccessResponse(T data) {
    Response<T> response = generateSuccessResponse();
    response.setData(data);
    return response;

  }
  public static <T> Response<T> generateSuccessResponse() {
    Response<T> response = new Response<>();
    response.setStatus(StatusEnum.SUCCESS);
    return response;

  }
  private String httpServletRequestToString(HttpServletRequest request) {
    StringBuilder sb = new StringBuilder();

    sb.append("Request Method = [" + request.getMethod() + "], ");
    sb.append("Request URL Path = [" + request.getRequestURL() + "], ");

    String headers = Collections.list(request.getHeaderNames()).stream()
        .map(headerName -> headerName + " : " + Collections.list(request.getHeaders(headerName)))
        .collect(Collectors.joining(", "));

    if (headers.isEmpty()) {
      sb.append("Request headers: NONE,");
    } else {
      sb.append("Request headers: [" + headers + "],");
    }

    String parameters = Collections.list(request.getParameterNames()).stream()
        .map(p -> p + " : " + Arrays.asList(request.getParameterValues(p)))
        .collect(Collectors.joining(", "));

    if (parameters.isEmpty()) {
      sb.append("Request parameters: NONE.");
    } else {
      sb.append("Request parameters: [" + parameters + "].");
    }

    return sb.toString();
  }
}
