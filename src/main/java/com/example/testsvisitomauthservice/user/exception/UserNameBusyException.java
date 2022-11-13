package com.example.testsvisitomauthservice.user.exception;

public class UserNameBusyException extends Exception {
    public UserNameBusyException() {
        super(ExceptionMessages.USER_USERNAME_BUSY.name());
    }

    public UserNameBusyException(String message) {
        super(message);
    }
}
