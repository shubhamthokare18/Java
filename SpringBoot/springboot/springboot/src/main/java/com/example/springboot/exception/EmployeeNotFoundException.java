package com.example.springboot.exception;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String message){
        super(message);
    }
}
