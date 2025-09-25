package com.example.springboot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Eidiko {

    @Id
    @SequenceGenerator(name = "eidiko_seq", allocationSize = 20, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "eidiko_seq")
    private int empId;
    private String empName;
    private double empSalary;
}
