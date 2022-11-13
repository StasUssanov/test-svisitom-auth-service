package com.example.testsvisitomauthservice.token.exception;

public class TokenWrongException extends Exception {
    public TokenWrongException() {
        super(ExceptionMessages.TOKEN_WRONG.name());
    }

    public TokenWrongException(String message) {
        super(message);
    }
}
