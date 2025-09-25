package com.example.Task.entity.oracle;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OracleEmployee {
    @Id
    @SequenceGenerator(name = "seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Long id;

    private String name;
    private Integer age;
    private String department;
    private Double salary;
}
