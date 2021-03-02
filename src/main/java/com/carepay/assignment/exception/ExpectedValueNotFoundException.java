package com.carepay.assignment.exception;

public class ExpectedValueNotFoundException extends RuntimeException {
    /**
     * Exception when The Response from DB is empty
     * for a particular ID of Post or Comment
     * @param message response
     */
    public ExpectedValueNotFoundException(String message) {
        super("Exception : " + message);
    }
}
