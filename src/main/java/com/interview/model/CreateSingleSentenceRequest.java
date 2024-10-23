package com.interview.model;

import lombok.Data;

/**
 * The CreateSingleSentenceRequest class represents a request to create a new single sentence.
 * It contains information about the book ID, the sentence value, and the word count of the sentence.
 */
@Data
public class CreateSingleSentenceRequest {

    /**
     * The bookId variable represents the ID of a book.
     */
    public String bookId;

    /**
     * Represents a string value of sentence.
     */
    public String value;

    /**
     * The wordCount variable represents the count of words in a sentence.
     */
    public Integer wordCount;

}
