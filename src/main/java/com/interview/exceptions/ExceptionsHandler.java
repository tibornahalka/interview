package com.interview.exceptions;

import com.interview.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * The ExceptionsHandler class is responsible for handling exceptions thrown by the application.
 * It is annotated with @RestControllerAdvice to handle exceptions globally across all controllers.
 */
@RestControllerAdvice
public class ExceptionsHandler {

    /**
     * Handles the exception when a record is not found. It creates an ErrorResponse object with the exception message and
     * sets the status to HttpStatus.NOT_FOUND.
     *
     * @param exception The RecordNotFoundException instance thrown by the application.
     * @return An ErrorResponse object containing the error message and status.
     */
    @ExceptionHandler(RecordNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleRecordNotFoundException(RecordNotFoundException exception) {
        return ErrorResponse.builder()
                .message(exception.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .build();
    }
}
