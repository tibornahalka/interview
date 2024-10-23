package com.interview.model;

import lombok.Builder;
import org.springframework.http.HttpStatus;

/**
 * The ErrorResponse class represents an error response object.
 */
@Builder
public class ErrorResponse {

    /**
     * This variable represents a message.
     * <p>
     * The message provides information or instructions to the recipient. It can be a string of characters that
     * conveys a particular meaning or context.
     */
    public String message;

    /**
     * The status field represents the HTTP status code of an error response.
     */
    public HttpStatus status;
}
