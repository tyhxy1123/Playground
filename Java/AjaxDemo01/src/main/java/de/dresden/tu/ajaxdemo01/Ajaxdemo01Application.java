package de.dresden.tu.ajaxdemo01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Ajaxdemo01Application {

    public static void main(String[] args) {
        SpringApplication.run(Ajaxdemo01Application.class, args);
    }

    @Configuration
    static class WebConfiguration implements WebMvcConfigurer{
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
//            registry.addResourceHandler("/webjars");
        }
    }
}
