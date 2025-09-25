package com.example.Person.exception;

public class PersonNameNotFoundException extends RuntimeException{
    public PersonNameNotFoundException(String message){
        super(message);
    }
}
