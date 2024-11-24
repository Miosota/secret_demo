package org.secretproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.secretproject.model.CommonObject;
import org.secretproject.model.Secret;
import org.secretproject.model.User;
import org.secretproject.service.SecretService;
import org.secretproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;


@RestController
@RequestMapping("/secret_demo")
@CrossOrigin
public class CommonController {

    @Autowired
    UserService userService;
    @Autowired
    SecretService secretService;
    @Autowired
    EntityManager entityManager;

    // @GetMapping("/getAll")
    // public List<User> getAllUsers(){
    //     return userService.getAllUsers();
    // }

    // @GetMapping("/id={id}")
    // public User getUserById(@PathVariable("id") Long id){
    //     return userService.getUserById(id);
    // }

    @PostMapping("/createobjects")
    public void createUser(@RequestBody CommonObject commonObject){
        User user = new User(commonObject.getUserName());
        Secret secret = new Secret(user, commonObject.getSecretText(), commonObject.getTimesToView());
        List<Secret> secretList = new ArrayList<>();
        secretList.add(secret);
        user.setSecrets(secretList);
        EntityTransaction transaction = entityManager.getTransaction();
    transaction.begin();
    entityManager.persist(user);
    entityManager.flush();
    transaction.commit();

    entityManager.clear();
        userService.createUser(user);
        System.out.println("Test : userId: "+user.getId());
        secretService.createSecret(secret);
        // return ;
    }

    // @DeleteMapping("/id={id}")
    // public void deleteUser(@PathVariable("id") Long id){
    //     userService.deleteUser(id);
    // }
}
