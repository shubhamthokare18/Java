package com.example.securityapplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Users")
public class User {
    @Id
    @SequenceGenerator(name = "sg", allocationSize = 50, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sg")
    private Integer id;
    private String name;
    private String mail;
    private String pass;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "userRole",
            joinColumns=@JoinColumn(name = "userId"),
            inverseJoinColumns=@JoinColumn(name = "roleId"))
    private Set<Role> role=new HashSet<>();
}
