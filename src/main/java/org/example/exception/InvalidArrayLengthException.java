package org.example.exception;

public class InvalidArrayLengthException extends RuntimeException {
    public InvalidArrayLengthException() {
    }

    public InvalidArrayLengthException(String message) {
        super(message);
    }
}