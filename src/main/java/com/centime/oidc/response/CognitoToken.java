package com.centime.oidc.response;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CognitoToken {

  @JsonProperty("id_token")
  protected String idToken;

  @JsonProperty("access_token")
  protected String accessToken;

  @JsonProperty("refresh_token")
  protected String refreshToken;

  @JsonProperty("expires_in")
  protected Long expiresInMillis;

  @JsonProperty("token_type")
  protected String tokenType;

}
