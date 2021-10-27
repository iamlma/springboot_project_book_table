package com.example.springboot_project_demo.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
@Data
public class DBConfiguration {
    private String driverClassName;
    private String url;
    private String userName;
    private String password;

    @Profile("dev")
    @Bean
    public String devDBConnection() {
        String message = "DB Connection for DEV";
        printDetails(message);
        return message;
    }

    @Profile("test")
    @Bean
    public String testDBConnection() {
        String message = "DB Connection for TEST";
        printDetails(message);
        return message;
    }

    @Profile("prod")
    @Bean
    public String prodDBConnection() {
        String message = "DB Connection for PROD";
        printDetails(message);
        return message;
    }

    private void printDetails(String message) {
        System.out.println(message);
        System.out.println(driverClassName);
        System.out.println(url);
        System.out.println(userName);
        System.out.println(password);
    }
}
