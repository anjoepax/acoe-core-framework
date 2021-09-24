package org.acoe.com.exceptions;

/**
 * Custom exception for properties file not found exception
 * @date September 23, 2021
 * @author Anthony Joseph Manigos
 */
public class PropertyFileNotFoundException extends FrameworkExceptions {

    public PropertyFileNotFoundException(String message) {
        super(message);
    }

    public PropertyFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
