package com.example.springsecurity.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long blogId;

    private String blogTitle;
    private String description;
    private String summary;
    private String blogText;

    @OneToOne
    private Author author;
    private LocalDateTime creationTime;
    private LocalDateTime lastUpdatedTime;

}