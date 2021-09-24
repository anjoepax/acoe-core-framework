package org.acoe.com.exceptions;

/**
 * Custom annotation created specifically for the framework
 * <p>
 *     Extends java RuntimeException
 * </p>
 *
 * @date September 23, 2021
 * @author Anthony Joseph Manigos
 *
 */
public class FrameworkExceptions extends RuntimeException {

    public FrameworkExceptions(String message) {
        super(message);
    }

    public FrameworkExceptions(String message, Throwable cause) {
        super(message, cause);
    }
}
