package com.example.Person_8_7_2025.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonResponse<T> {
    private String message;
    private T data;
}
