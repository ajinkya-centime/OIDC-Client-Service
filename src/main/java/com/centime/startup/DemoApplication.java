package com.centime.startup;

import com.centime.logging.CentimeLogger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(scanBasePackages = "com.centime")
@EnableConfigurationProperties
public class DemoApplication {
  private static final CentimeLogger log = CentimeLogger.getLogger();

  // TODO:Rename/Refactor DemoApplication to specific app

  public static void main(String[] args) {

    // TODO:change log messages belows

    log.info("Starting Template Micro Services.");
    SpringApplication.run(DemoApplication.class, args);

    log.info("Template Micro Services successfully started");
  }

}
