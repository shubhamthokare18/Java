package com.example.Sept9_SpringSecurity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {

    private String username;
    private String password;
    private String email;
    private Set<String>roles=new HashSet<>();
}
