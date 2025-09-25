package com.example.Person_8_7_2025.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @SequenceGenerator(name = "person_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_sequence")
    private int id;
    private String name;
    private String city;
}
