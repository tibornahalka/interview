package com.interview.model;

import lombok.Data;


/**
 * The SentenceDto class represents a Data Transfer Object (DTO) for a sentence.
 * It contains information about the ID, value, and word count of a sentence.
 * The class is annotated with the lombok @Data and @Builder annotations, which automatically generate the getters, setters, and builder methods for the properties.
 */
@Data
public class SentenceDto {

    /**
     * The id variable represents the ID of a SentenceDto object.
     * It is a String value that uniquely identifies the sentence.
     */
    public String id;

    /**
     * The value variable represents the value of a sentence in the SentenceDto class.
     */
    public String value;

    /**
     * The wordCount variable represents the number of words in a sentence.
     * It is of type Integer and its value can be null.
     */
    public Integer wordCount;
}
