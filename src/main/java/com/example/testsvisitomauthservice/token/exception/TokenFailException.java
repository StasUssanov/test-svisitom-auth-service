package com.example.testsvisitomauthservice.token.exception;

public class TokenFailException extends Exception {
    public TokenFailException() {
        super(ExceptionMessages.TOKEN_FAIL.name());
    }

    public TokenFailException(String message) {
        super(message);
    }
}
