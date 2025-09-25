package com.example.Sept9_SpringSecurity.service;

import com.example.Sept9_SpringSecurity.dto.AuthRequestDto;
import com.example.Sept9_SpringSecurity.dto.UserRequestDto;
import com.example.Sept9_SpringSecurity.entity.Role;
import com.example.Sept9_SpringSecurity.entity.User;
import com.example.Sept9_SpringSecurity.repository.RoleRepository;
import com.example.Sept9_SpringSecurity.repository.UserRepository;
import com.example.Sept9_SpringSecurity.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    public User registerUser(UserRequestDto user)
    {
        Set<Role> roles = user.getRoles().stream()
                .map(role -> roleRepository.findByName(String.valueOf(role))
                        .orElseThrow(() -> new RuntimeException("Role not found: " )))
                .collect(Collectors.toSet());
        User user1=new User();
        user1.setEmail(user.getEmail());
        user1.setPassword(passwordEncoder.encode(user.getPassword()));
        user1.setUsername(user.getUsername());
        user1.setRoles(roles);
        return userRepository.save(user1);
    }

    public String authenticate(AuthRequestDto authRequestDto)
    {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequestDto.getUsername(), authRequestDto.getPassword())
        );
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(authRequestDto.getUsername());
        String token = jwtUtil.generateToken(userDetails);
        return token;
    }
}
