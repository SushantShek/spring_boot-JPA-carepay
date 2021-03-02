package com.carepay.assignment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Controller Advice
 * to handle all the custom exception
 * thrwn by the application
 */
@ControllerAdvice
public class PostCommentExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidPostOperationException.class)
    public ResponseEntity<String> handleMaxSizeException(InvalidPostOperationException exc) {
        return new ResponseEntity<>(exc.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CommentOperationsException.class)
    public ResponseEntity<String> handleCommentsException(CommentOperationsException exc) {
        return new ResponseEntity<>(exc.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ExpectedValueNotFoundException.class)
    public ResponseEntity<String> handleNullValueException(ExpectedValueNotFoundException exc) {
        return new ResponseEntity<>(exc.getMessage(), HttpStatus.EXPECTATION_FAILED);
    }

}
