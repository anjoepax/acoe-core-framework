package org.acoe.com.exceptions;

/**
 * Custom exception for invalid excel data path encountered
 * <p>
 *     Extends the FrameworkExceptions class
 * </p>
 *
 * @date September 23, 2021
 * @author Anthony Joseph Manigos
 * @see FrameworkExceptions
 */
public class InvalidPathForExcelException extends FrameworkExceptions {

    public InvalidPathForExcelException(String message) {
        super(message);
    }

    public InvalidPathForExcelException(String message, Throwable cause) {
        super(message, cause);
    }
}
