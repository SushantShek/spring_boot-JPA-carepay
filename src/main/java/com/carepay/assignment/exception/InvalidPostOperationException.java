package com.carepay.assignment.exception;

public class InvalidPostOperationException extends RuntimeException {
    /**
     * Exception related to Posts and related operations
     * @param message response
     */
    public InvalidPostOperationException(String message) {
        super("Exception : " + message);
    }
}
