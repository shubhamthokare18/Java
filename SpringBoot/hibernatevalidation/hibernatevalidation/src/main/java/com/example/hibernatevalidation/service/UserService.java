package com.example.hibernatevalidation.service;

import com.example.hibernatevalidation.entity.UserName;
import com.example.hibernatevalidation.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public UserName createUser(UserName user){
        return userRepository.save(user);
    }
}