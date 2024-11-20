package org.secretproject.service;

import java.util.List;

import org.secretproject.model.Secret;
import org.secretproject.repository.SecretRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecretService {
    
    private final SecretRepository secretRepository;

    @Autowired
    public SecretService(SecretRepository secretRepository) {
        this.secretRepository = secretRepository;
    }

    public List<Secret> getAllSecrets() {
        return secretRepository.findAll();
    }

    public Secret getSecretById(Long id){
        return secretRepository.findById(id).orElse(null);
    }

    public Secret createSecret(Secret secret){
        return secretRepository.save(secret);
    }

    public Secret updateSecret(Secret secret){
        return secretRepository.save(secret);
    }

    public void deleteSecret(Long id){
        secretRepository.deleteById(id);
    }

}
