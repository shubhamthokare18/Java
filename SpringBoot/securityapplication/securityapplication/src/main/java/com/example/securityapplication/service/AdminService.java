package com.example.securityapplication.service;

import com.example.securityapplication.entity.User;
import com.example.securityapplication.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private UserRepo userRepo;
    public User findById(Integer id){
        return userRepo.findById(id).get();
    }
}
