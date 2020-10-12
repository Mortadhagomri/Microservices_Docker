package com.code.repartis.Controller;

import java.util.List;

import com.code.repartis.entities.User;
import com.code.repartis.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/listUsers")
    public List<User> listUsers(){
        return userRepository.findAll();
    }

    @GetMapping(value="/user/{id}")
    public User findUser(@PathVariable(name="id") Long id){
        return userRepository.findById(id).get();
    }

    @PostMapping("/saveUser")
    public User save(@RequestBody User usr){
        return userRepository.save(usr);
    }
  

}
