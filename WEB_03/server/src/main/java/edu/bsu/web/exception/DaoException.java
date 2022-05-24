package edu.bsu.web.exception;

/**
 * Custom exception. Throws when DAO method couldn't work correctly
 * @author Aleksandr_Dzyachenka
 */
public class DaoException extends Exception {

    /**
     * Constructor with text message
     * @param message - text message
     */
    public DaoException(String message) {
        super(message);
    }

    /**
     * Constructor with text message and error cause
     * @param message - text message
     * @param cause - error cause
     */
    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
