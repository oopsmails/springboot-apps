package com.oopsmails.springboot.security.oauth2.angular.resourceserver.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan({ "com.oopsmails.springboot.security.oauth2.angular.resourceserver.web" })
public class ResourceServerWebConfig extends WebMvcConfigurerAdapter {
    //
}
