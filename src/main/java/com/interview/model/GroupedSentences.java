package com.interview.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * The GroupedSentences class represents a group of sentences that are associated with a specific book.
 * It contains the book ID and a list of SentenceDto objects representing the sentences in the group.
 */
@Data
@Builder
public class GroupedSentences {

    /**
     * The bookId variable represents the ID of a book.
     * It is of type String and is annotated with @JsonProperty to indicate that it should be included when serializing and deserializing JSON objects.
     * The value of the bookId variable uniquely identifies a book within the context of a GroupedSentences object.
     */
    @JsonProperty
    String bookId;

    /**
     * Represents a list of sentence data transfer objects.
     * The sentences are represented by objects of the SentenceDto class.
     * <p>
     * The list is annotated with @JsonProperty to indicate that it will be serialized/deserialized using the JSON property "sentences".
     * <p>
     * Note that this variable is a member of the GroupedSentences class, which represents a group of sentences associated with a specific book.
     * The GroupedSentences class has a book ID (as a String) and a list of SentenceDto objects.
     */
    @JsonProperty
    List<SentenceDto> sentences;
}
