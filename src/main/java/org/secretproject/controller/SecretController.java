package org.secretproject.controller;

import java.util.List;

import org.secretproject.model.Secret;
import org.secretproject.service.SecretService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secrets")
public class SecretController {

    private final SecretService secretService;

    @Autowired
    public SecretController(SecretService secretService) {
        this.secretService = secretService;
    }

    @GetMapping
    public List<Secret> getAllSecrets() {
        return secretService.getAllSecrets();
    }

    @GetMapping("/{id}") 
    public Secret getSecretById (@PathVariable Long id) {
        return secretService.getSecretById(id);
    }

    @PostMapping
    public Secret createSecret (@RequestBody Secret secret){
        return secretService.createSecret(secret);
    }

    @PutMapping("/{id}")
    public Secret updateSecret (@PathVariable Long id, @RequestBody Secret secret){
        secret.setId(id);
        return secretService.updateSecret(secret);
    }

    @DeleteMapping("/{id}")
    public void deleteSecret (@PathVariable Long id){
        secretService.deleteSecret(id);
    }

}
