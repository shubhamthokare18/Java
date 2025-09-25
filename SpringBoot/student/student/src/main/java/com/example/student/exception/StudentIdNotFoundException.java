package com.example.student.exception;

public class StudentIdNotFoundException extends RuntimeException{
    public StudentIdNotFoundException(String message){
        super(message);
    }
}
