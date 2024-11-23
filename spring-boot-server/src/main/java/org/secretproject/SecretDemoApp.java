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
        System.out.println("Hi ");
    }

    @Bean
    public CommandLineRunner demo() {
        return args -> {
            User newUser = new User("TestUser");
            userService.createUser(newUser);

            Secret testSecret = new Secret(newUser,"secretText", 3);
            secretService.createSecret(testSecret);
            
            System.out.println("Hi again");

            User savedUser = userService.getUserById(newUser.getId());
            System.out.println("Saved User: " + savedUser);


            Secret savedSecret = secretService.getSecretById(testSecret.getId());
            System.out.println("Saved Secret: " + savedSecret);
        };
    }

  
}