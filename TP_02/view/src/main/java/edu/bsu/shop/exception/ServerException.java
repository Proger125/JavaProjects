package edu.bsu.shop.exception;

public class ServerException extends RuntimeException{

    public ServerException() {
        super();
    }

    public ServerException(String message) {
        super(message);
    }
}
