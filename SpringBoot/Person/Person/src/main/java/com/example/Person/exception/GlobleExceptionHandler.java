package com.example.Person.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobleExceptionHandler {

    @ExceptionHandler(PersonIdNotFoundException.class)
    public ResponseEntity<ErrorResponse> personIdNotFound(PersonIdNotFoundException ex){
        ErrorResponse response = new ErrorResponse(ex.getMessage(), "Searched Person Id Not Found", LocalDateTime.now(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(PersonNameNotFoundException.class)
    public ResponseEntity<ErrorResponse> personNameNotFound(PersonNameNotFoundException
                                                            personNameNotFoundException){
        ErrorResponse errorResponse=new ErrorResponse(personNameNotFoundException.getMessage(), "Searched Person Name Not Found", LocalDateTime.now(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
