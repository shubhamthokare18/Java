package com.example.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Map<String, String>> EmployeeNotFoundException(EmployeeNotFoundException employeeNotFoundException){
        Map<String, String> m=new HashMap<>();
        m.put("message", "employee not found");
        m.put("http status code", HttpStatus.NOT_FOUND.toString());
        return new ResponseEntity<>(m,HttpStatus.NOT_FOUND);
    }
}
