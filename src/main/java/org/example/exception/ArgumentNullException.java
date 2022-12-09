package org.example.exception;

public class ArgumentNullException extends RuntimeException {
    public ArgumentNullException() {
    }

    public ArgumentNullException(String message) {
        super(message);
    }
}
