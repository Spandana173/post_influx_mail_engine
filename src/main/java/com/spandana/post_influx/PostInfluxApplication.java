package com.spandana.post_influx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PostInfluxApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostInfluxApplication.class, args);
    }

    // The explicit JavaMailSender configuration bean has been removed!
    // Spring Boot automatically reads the encrypted credentials from your
    // application.properties file and injects them safely into your EmailService.
}