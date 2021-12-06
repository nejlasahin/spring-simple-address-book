package com.project.springsimpleaddressbook.exception;

public class IdentityNumberIsAlreadyExistException extends RuntimeException{
    public IdentityNumberIsAlreadyExistException(String message) {
        super(message);
    }
}
