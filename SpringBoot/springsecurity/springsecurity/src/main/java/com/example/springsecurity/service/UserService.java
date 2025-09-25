package com.example.springsecurity.service;

import com.example.springsecurity.entity.BlogUsers;
import com.example.springsecurity.repository.UsersRepository;
import com.example.springsecurity.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtil jwtUtil;

    public BlogUsers postNewUsers(BlogUsers blogUsers) {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode(blogUsers.getPassword());

        blogUsers.setPassword(encode);

        return usersRepository.save(blogUsers);
    }

    public String authenticateUser(BlogUsers blogUsers) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(blogUsers.getUserName(), blogUsers.getPassword()));

        if (authentication.isAuthenticated()) {
            return jwtUtil.generateJWTToken(blogUsers.getUserName());
        }
        throw new RuntimeException("Authentication Failed");
    }
}