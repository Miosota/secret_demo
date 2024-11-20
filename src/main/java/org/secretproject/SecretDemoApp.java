package org.secretproject;

import org.secretproject.model.Secret;
import org.secretproject.model.User;
import org.secretproject.service.SecretService;
import org.secretproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.XADataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
// @EnableJpaRepositories
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class, XADataSourceAutoConfiguration.class})
public class SecretDemoApp {

    // @Autowired
    UserService userService;
    // @Autowired
    SecretService secretService;

    @Autowired
    public SecretDemoApp (UserService userService, SecretService secretService) {
        this.userService = userService;
        this.secretService = secretService;
    }
    
    public static void main(String[] args) {
        SpringApplication.run(SecretDemoApp.class, args);
        System.out.println("Hi ");


    }

    @Bean
    public CommandLineRunner demo() {
        return args -> {
            User newUser = new User("TestUser");
            userService.createUser(newUser);

            Secret testSecret = new Secret(newUser,"testLogin","testPassword", 3);
            secretService.createSecret(testSecret);
            
            System.out.println("Hi again");

            User savedUser = userService.getUserById(newUser.getId());
            System.out.println("Saved User: " + savedUser);


            Secret savedSecret = secretService.getSecretById(testSecret.getId());
            System.out.println("Saved Secret: " + savedSecret);
        };
    }

  
}