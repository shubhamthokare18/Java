package com.ashar.profileManager.exception;

public class ProfileNotFoundException extends  RuntimeException{

    public ProfileNotFoundException(String message)
    {
        super(message);
    }
}
