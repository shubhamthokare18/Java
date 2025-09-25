package com.example.springsecurity.entity;

import com.example.springsecurity.util.Role;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogUsers {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int userId;

    private String userName;

    private String password;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Roles> roles = new HashSet<>();


}