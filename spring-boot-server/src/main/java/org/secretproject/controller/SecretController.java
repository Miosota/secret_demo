package org.secretproject.controller;

import java.util.List;

import org.secretproject.model.Secret;
import org.secretproject.service.SecretService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/secrets")
public class SecretController {

    @Autowired
    SecretService secretService;

    @GetMapping("/getAll")
    public List<Secret> getAllSecrets() {
        return secretService.getAllSecrets();
    }

    @GetMapping("/id={id}") 
    public Secret getSecretById (@PathVariable("id") Long id) {
        return secretService.getSecretById(id);
    }

    @PostMapping("/createSecret")
    public Secret createSecret (@RequestBody Secret secret){
        return secretService.createSecret(secret);
    }

    @PutMapping("/id={id}")
    public Secret updateSecret (@PathVariable("id") Long id, @RequestBody Secret secret){
        secret.setId(id);
        return secretService.updateSecret(secret);
    }

    @DeleteMapping("/id={id}")
    public void deleteSecret (@PathVariable("id") Long id){
        secretService.deleteSecret(id);
    }

}
