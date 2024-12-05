package org.secretproject;

import org.secretproject.model.Secret;
import org.secretproject.model.User;
import org.secretproject.service.SecretService;
import org.secretproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SecretDemoApp {

    @Autowired
    UserService userService;
    @Autowired
    SecretService secretService;
    
    public static void main(String[] args) {
        SpringApplication.run(SecretDemoApp.class, args);
        System.out.println("Started App");
    }

}