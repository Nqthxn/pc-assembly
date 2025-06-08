package com.example.pcbuilderapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // This configuration applies to all API paths
                registry.addMapping("/api/**")
                        // Allow requests from your Angular development server's origin
                        .allowedOrigins("http://localhost:4200")
                        // Allow the standard HTTP methods, including OPTIONS for preflight
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        // Allow all headers in the request
                        .allowedHeaders("*")
                        // Allow credentials (like cookies or auth tokens) to be sent
                        .allowCredentials(true);
            }
        };
    }
}