package com.example.Sept9_SpringSecurity.service;

import com.example.Sept9_SpringSecurity.entity.User;
import com.example.Sept9_SpringSecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(int id)
    {
        return userRepository.findById(id).get();
    }
}
