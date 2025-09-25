package com.example.ocrdemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AadhaarDetails {
    @Id
    @SequenceGenerator(name = "sg",initialValue = 1, allocationSize = 50)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sg")
    private Long id;

    private String name;
    private String dob;
    private String gender;

//    public void setName(String trim) {
//    }
//
//    public void setDob(String group) {
//    }
//
//    public void setGender(String male) {
//    }

    // Getters & Setters
}
