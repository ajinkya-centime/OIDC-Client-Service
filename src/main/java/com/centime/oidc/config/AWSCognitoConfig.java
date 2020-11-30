package com.centime.oidc.config;

import lombok.Getter;
import lombok.Setter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("cognito")
@Getter
@Setter
public class AWSCognitoConfig {
  protected String poolBaseURL;
  protected String tokenURL;
  protected String headerContentType;
  protected String authorization;
  protected String grantType;
  protected String poolAppId;
  protected String redirectURI;
}
