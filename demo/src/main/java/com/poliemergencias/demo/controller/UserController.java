package com.poliemergencias.demo.controller;

import com.poliemergencias.demo.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "*") // para permitir llamados desde cualquier frontend
@RestController
public class UserController {
    @GetMapping("/user")
    public ResponseEntity<User> getUser(){
        User user = new User("david","123456","admin");
        return ResponseEntity.ok(user);
    }
}
