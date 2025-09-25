package com.example.hibernatevalidation.controller;

import com.example.hibernatevalidation.entity.UserName;
import com.example.hibernatevalidation.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/create")
    public UserName createUser(@Valid @RequestBody UserName user){
        return userService.createUser(user);
    }
}
