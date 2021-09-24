package org.acoe.com.exceptions;

/**
 * Custom exception for property key not found
 * @date September 23, 2021
 * @author Anthony Joseph Manigos
 */
public class PropertyKeyNotFoundException extends FrameworkExceptions {

    public PropertyKeyNotFoundException(String message) {
        super(message);
    }

    public PropertyKeyNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
