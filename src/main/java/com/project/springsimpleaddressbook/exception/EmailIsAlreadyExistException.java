package com.project.springsimpleaddressbook.exception;

public class EmailIsAlreadyExistException extends RuntimeException{
    public EmailIsAlreadyExistException(String message) {
        super(message);
    }
}
