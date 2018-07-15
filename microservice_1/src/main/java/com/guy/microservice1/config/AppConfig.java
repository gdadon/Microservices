package com.guy.microservice1.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.guy.microservice1"})
public class AppConfig {
}
