package com.example.securityapplication.service;

import com.example.securityapplication.entity.User;
import com.example.securityapplication.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        System.out.println(name);
        User user=userRepo.findByName(name).orElseThrow(()-> new UsernameNotFoundException("user not found"));
        Set<GrantedAuthority> grantedAuthorities=user.getRole().stream().map(role->new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());
        grantedAuthorities.stream().forEach(System.out::println);
        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPass(), grantedAuthorities);
    }
}
