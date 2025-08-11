package com.fcproject.exception;

public class GlobalErrorException extends RuntimeException {
    public GlobalErrorException(String message) {
        super(message);
    }
}
