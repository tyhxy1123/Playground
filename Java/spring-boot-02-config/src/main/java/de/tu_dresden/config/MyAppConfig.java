package de.tu_dresden.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import de.tu_dresden.service.HelloService;

@Configuration
public class MyAppConfig {
    @Bean
    public HelloService helloService() {
        return new HelloService();
    }

}