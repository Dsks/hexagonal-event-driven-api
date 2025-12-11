package com.appsds.retail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the Retail Orders Backend application.
 *
 * <p>This application follows Hexagonal Architecture and uses Event-Driven patterns.
 */
@SpringBootApplication
public class RetailApplication {

  public static void main(String[] args) {
    SpringApplication.run(RetailApplication.class, args);
  }

}
