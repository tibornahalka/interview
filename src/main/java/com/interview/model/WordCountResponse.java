package com.interview.model;

import lombok.Builder;

/**
 * The WordCountResponse class represents a response object that contains the word count of a sentence.
 * It is used to encapsulate the word count value and send it back to the client.
 */
@Builder
public class WordCountResponse {

    /**
     * Represents the word count of a sentence.
     */
    public int wordCount;
}
