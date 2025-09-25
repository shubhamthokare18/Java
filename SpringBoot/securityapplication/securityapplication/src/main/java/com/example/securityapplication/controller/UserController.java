package com.example.securityapplication.controller;

import com.example.securityapplication.dto.LogInDto;
import com.example.securityapplication.dto.UserDto;
import com.example.securityapplication.entity.User;
import com.example.securityapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.registerUser(userDto));
    }
    @GetMapping("/login")
    public ResponseEntity<String> logIn(@RequestBody LogInDto logInDto){
return ResponseEntity.ok(userService.logIn(logInDto));
    }
}
