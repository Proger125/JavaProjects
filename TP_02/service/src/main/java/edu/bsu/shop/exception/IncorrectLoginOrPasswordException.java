package edu.bsu.shop.exception;

public class IncorrectLoginOrPasswordException extends RuntimeException {

    public IncorrectLoginOrPasswordException() {
        super();
    }

    public IncorrectLoginOrPasswordException(String message) {
        super(message);
    }
}
