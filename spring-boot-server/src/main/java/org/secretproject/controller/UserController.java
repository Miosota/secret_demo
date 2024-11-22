package org.secretproject.controller;

import java.util.List;

import org.secretproject.model.User;
import org.secretproject.repository.UsersRepository;
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


@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    @Autowired
    UsersRepository userService;

    // @Autowired
    // public UserController(UserService userService) {
    //     this.userService = userService;
    // }

    @GetMapping("/getAll")
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/id={id}")
    public User getUserById(@PathVariable("id") Long id){
        return userService.findById(id).orElse(null);
    }

    @PostMapping("/createUser")
    public User createUser(@RequestBody User user){
        return userService.save(user);
    }

    @DeleteMapping("/id={id}")
    public void deleteUser(@PathVariable("id") Long id){
        userService.deleteById(id);
    }
}
