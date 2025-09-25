package com.example.springsecurity.entity;

import com.example.springsecurity.util.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Roles {

    @Id
    private int roleId;

    @Enumerated(EnumType.STRING)
    private Role role;
}