package com.carepay.assignment.exception;

public class CommentOperationsException extends RuntimeException {
    /**
     * Exception related to comments
     * @param message response
     */
    public CommentOperationsException(String message) {
        super("Exception : " + message);
    }
}
