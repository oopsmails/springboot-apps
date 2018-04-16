package com.oopsmails.springboot.security.oauth2.angular.resourceserver.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringbootSecurityOAuth2AngularResourceApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSecurityOAuth2AngularResourceApplication.class, args);
    }

}