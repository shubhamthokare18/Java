package com.example.Person.exception;

public class PersonIdNotFoundException extends RuntimeException{
    public PersonIdNotFoundException(String message){
        super(message);
    }
}
