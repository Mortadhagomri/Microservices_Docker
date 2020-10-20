package com.code.repartis.Controller;

import java.util.List;

import com.code.repartis.Services.CommentService;
import com.code.repartis.Services.DataBase;
import com.code.repartis.Services.PostService;
import com.code.repartis.entities.User;
import com.code.repartis.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserController {

    @Autowired
    private CommentService commService;

    @Autowired
    private PostService postService;

    @Autowired
    private DataBase db;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/fill-db")
    public void filldatabase(){
        db.filldb();
    }

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

    @PutMapping(value="/updateUser/{id}")
    public User update(@PathVariable(name="id") Long id,@RequestBody User usr){
        usr.setId(id);
        return userRepository.save(usr);
    }

    @DeleteMapping(value="/users/{id}")
        public ResponseEntity<Long> deleteUser(@PathVariable Long id){
            userRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value="/getComments/{id}")
    public List<Object> getComments(@PathVariable(name="id") Long id){
       return commService.getUserComments(id);
    }

    @GetMapping(value="/delete-all-users")
    public ResponseEntity<Long> deleteUsers(){
        userRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value="/getPosts/{id}")
    public List<Object> getPosts(@PathVariable(name="id") Long id){
        return postService.getuserposts(id);
    }

}
