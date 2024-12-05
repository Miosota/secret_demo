package org.secretproject.controller;


import java.util.ArrayList;
import java.util.List;

import org.secretproject.model.CommonObject;
import org.secretproject.model.Secret;
import org.secretproject.model.User;
import org.secretproject.service.SecretService;
import org.secretproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@RestController
@RequestMapping("/secret_demo")
@CrossOrigin
public class CommonController {


    @Autowired
    UserService userService;
    @Autowired
    SecretService secretService;
    @PersistenceContext
    private EntityManager entityManager;


    @PostMapping("/createobjects")
    @Transactional
    public ResponseEntity<String> createUser(@RequestBody CommonObject commonObject){
        User user = new User(commonObject.getUserName());
        Secret secret = new Secret(user, commonObject.getSecretText(), commonObject.getTimesToView());

        List<Secret> secretList = new ArrayList<>();
        secretList.add(secret);
        user.setSecrets(secretList);
        entityManager.persist(user);
        entityManager.flush();
        entityManager.clear();

        userService.createUser(user);
        secretService.createSecret(secret);
        //generate url with user's secret text
        UriComponents builder = UriComponentsBuilder.newInstance()
        .scheme("http")
        .host("localhost:3000")
        .path("/secrets")
        .queryParam("secretid", secret.getId()).build();

    return new ResponseEntity<String>(builder.toString(), HttpStatus.OK);
    }

}
