package com.example.hibernatevalidation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
    public class UserName {
    @Id
    @NotNull(message = "id is required")
    private Integer id;
        @NotBlank(message="name cannot be blank")
        private String name;
        @Email(message = "invalid email")
        private String email;
        @Min(value = 18, message = "age must be atleast 18")
        private int age;
    @NotBlank(message = "department is required")
    private String department;


}