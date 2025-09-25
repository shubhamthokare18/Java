package com.example.securityapplication.service;

import com.example.securityapplication.dto.LogInDto;
import com.example.securityapplication.dto.UserDto;
import com.example.securityapplication.entity.Role;
import com.example.securityapplication.entity.User;
import com.example.securityapplication.repo.RoleRepo;
import com.example.securityapplication.repo.UserRepo;
import com.example.securityapplication.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private CustomUserDetailService customUserDetailService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public User registerUser(UserDto userDto){
        Set<Role> roles=userDto.getRole().stream().map(role->roleRepo.findByName(String.valueOf(role)).orElseThrow(()->new RuntimeException("role not found: "))).collect(Collectors.toSet());
        User user=new User();
        user.setName(userDto.getName());
        user.setMail(userDto.getMail());
        user.setPass(passwordEncoder.encode(userDto.getPass()));
        user.setRole(roles);
        return userRepo.save(user);
    }
    public String logIn(LogInDto logInDto){
        Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(logInDto.getName(), logInDto.getPass()));
        UserDetails userDetails=customUserDetailService.loadUserByUsername(logInDto.getName());
        String token=jwtUtil.generateToken(userDetails);
        return token;
    }
}
