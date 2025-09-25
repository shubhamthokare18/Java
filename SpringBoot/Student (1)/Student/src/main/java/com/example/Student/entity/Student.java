package com.example.Student.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @SequenceGenerator(name = "stu_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stu_seq")
    private long id;
    private String name;
    private String email;
}