package com.example.testsvisitomauthservice.session.exception;

public class SessionNotFoundException extends Exception {
    public SessionNotFoundException() {
        super(ExceptionMessages.SESSION_NOT_FOUND.name());
    }

    public SessionNotFoundException(String message) {
        super(message);
    }
}
