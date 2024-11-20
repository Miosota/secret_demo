package org.secretproject.service;

import java.util.List;

import org.secretproject.model.User;
import org.secretproject.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired(required = false)
    UsersRepository usersRepository;

    // @Autowired(required = false)
    // public UserService(UsersRepository userRepository) {
    //     this.usersRepository = userRepository;
    // }

    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }

    public User getUserById(Long id){
        return usersRepository.findById(id).orElse(null);
    }

    public User createUser(User user){
        return usersRepository.save(user);
    }

    public void deleteUser(Long id){
        usersRepository.deleteById(id);
    }

}
