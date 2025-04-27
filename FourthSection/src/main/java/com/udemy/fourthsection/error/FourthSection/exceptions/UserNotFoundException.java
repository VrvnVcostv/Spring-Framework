package com.udemy.fourthsection.error.FourthSection.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message){
        super(message);
    }
}
