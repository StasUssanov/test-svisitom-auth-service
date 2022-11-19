package com.example.testsvisitomauthservice.token.exception;

public class UsernameOrPasswordWrongException extends Exception {
    public UsernameOrPasswordWrongException() {
        super(ExceptionMessages.USERNAME_OR_PASSWORD_WRONG.name());
    }

    public UsernameOrPasswordWrongException(String message) {
        super(message);
    }
}
