package com.attractor.month9onlineshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class Month9OnlineshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(Month9OnlineshopApplication.class, args);
    }

}
