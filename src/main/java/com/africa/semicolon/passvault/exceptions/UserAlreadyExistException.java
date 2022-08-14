package com.africa.semicolon.passvault.exceptions;

public class UserAlreadyExistException extends PassVaultException {
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
