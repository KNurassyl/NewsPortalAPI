package com.example.newsportalapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.newsportalapi.*"})
public class NewsPortalApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewsPortalApiApplication.class, args);
    }

}
