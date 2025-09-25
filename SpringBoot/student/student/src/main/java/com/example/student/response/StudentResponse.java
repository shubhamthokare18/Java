package com.example.student.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse<T> {
    private String message;
    private LocalDateTime localDateTime;
    private T data;
    private int statusCode;
}
