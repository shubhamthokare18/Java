package com.example.student.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(StudentIdNotFoundException.class)
    public ResponseEntity<ErrorResponse> StudentIdNotFoundException(StudentIdNotFoundException studentIdNotFoundException){
        ErrorResponse errorResponse=new ErrorResponse(studentIdNotFoundException.getMessage(), "Searched Student Id Not Found", LocalDateTime.now(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(StudentNameNotFoundException.class)
    public ResponseEntity<ErrorResponse> StuentNameNotFound(StudentNameNotFoundException studentNameNotFoundException){
        ErrorResponse errorResponse=new ErrorResponse(studentNameNotFoundException.getMessage(), "Searched Student Name Not Found", LocalDateTime.now(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
