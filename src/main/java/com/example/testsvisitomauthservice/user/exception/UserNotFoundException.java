package com.example.testsvisitomauthservice.user.exception;

public class UserNotFoundException extends Exception {
    public UserNotFoundException() {
        super(ExceptionMessages.USER_NOT_FOUND.name());
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
