package com.example.securityapplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @SequenceGenerator(name = "sg", allocationSize = 50, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sg")
    private Integer id;
    private String name;
}
