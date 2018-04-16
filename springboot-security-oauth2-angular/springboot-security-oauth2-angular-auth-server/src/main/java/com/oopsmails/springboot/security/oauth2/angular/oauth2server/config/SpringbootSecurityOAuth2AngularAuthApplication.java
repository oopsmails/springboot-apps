package com.oopsmails.springboot.security.oauth2.angular.oauth2server.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringbootSecurityOAuth2AngularAuthApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSecurityOAuth2AngularAuthApplication.class, args);
    }

}