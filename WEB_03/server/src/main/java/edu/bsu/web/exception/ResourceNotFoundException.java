package edu.bsu.web.exception;

/**
 * Custom exception class. It throws when DAO method couldn't find something in the storage
 * @author Aleksandr_Dzyachenka
 */
public class ResourceNotFoundException extends Exception{

    /**
     * Default constructor
     */
    public ResourceNotFoundException() {
        super();
    }

    /**
     * Constructor with text message
     * @param message - text message
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }

    /**
     * Constructor with text message and error cause
     * @param message - text message
     * @param cause - error cause
     */
    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
