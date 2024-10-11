package com.project.group4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.project.group4.repository")
public class Group4Application {
    public static void main(String[] args) {
        SpringApplication.run(Group4Application.class, args);
    }
}
