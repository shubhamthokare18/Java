package com.example.actionservice.entity;

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
    @SequenceGenerator(name = "ssg", allocationSize = 50, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ssg")
    private Integer studentId;
    private String studentName;
    private String studentDepartment;
}
