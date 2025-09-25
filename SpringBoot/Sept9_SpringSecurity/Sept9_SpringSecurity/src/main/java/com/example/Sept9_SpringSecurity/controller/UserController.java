package com.example.Sept9_SpringSecurity.controller;


import com.example.Sept9_SpringSecurity.dto.AuthRequestDto;
import com.example.Sept9_SpringSecurity.dto.UserRequestDto;
import com.example.Sept9_SpringSecurity.entity.User;
import com.example.Sept9_SpringSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserRequestDto user)
    {
        return ResponseEntity.ok(userService.registerUser(user));
    }


    @GetMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody AuthRequestDto authRequestDto)
    {
        return ResponseEntity.ok(userService.authenticate(authRequestDto));
    }

}
