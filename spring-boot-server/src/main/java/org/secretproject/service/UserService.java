package org.secretproject.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.secretproject.model.User;
import org.secretproject.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  
    @Autowired
    private UsersRepository usersRepository;

    public List<User> getAllUsers() {
        return this.usersRepository.findAll();
    }

    public User getUserById(Long id){
        return this.usersRepository.findById(id).orElse(null);
    }

    public User createUser(User user){
        return this.usersRepository.save(user);
    }

    public void deleteUser(Long id){
        this.usersRepository.deleteById(id);
    }

}
