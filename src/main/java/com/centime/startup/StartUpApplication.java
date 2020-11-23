package com.centime.startup;

import com.centime.logging.CentimeLogger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(scanBasePackages = "com.centime")
@EnableConfigurationProperties
public class StartUpApplication {
	private static final CentimeLogger log = CentimeLogger.getLogger();



	public static void main(String[] args) {
		log.info("Starting Template Micro Services.");
		SpringApplication.run(StartUpApplication.class, args);

		log.info("Template Micro Services successfully started");
	}

}
