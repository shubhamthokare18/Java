package com.example.student.exception;

import org.aspectj.bridge.IMessage;

public class StudentNameNotFoundException extends RuntimeException{
    public StudentNameNotFoundException(String message){
        super(message);
    }
}
