package com.example.First_Spring_site.exceptions;

public class EmailAlreadyExistException extends Exception{
    public EmailAlreadyExistException(String message) {
        super(message);
    }
}
