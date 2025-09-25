package com.example.Sept9_SpringSecurity.controller;

import com.example.Sept9_SpringSecurity.entity.User;
import com.example.Sept9_SpringSecurity.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {


    @Autowired
    private AdminService adminService;


    @GetMapping("/id/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id)
    {
        return ResponseEntity.ok(adminService.getUserById(id));
    }
}
