package com.interview.model;

import lombok.Data;

import java.util.List;

/**
 * The BookDto class represents a Data Transfer Object (DTO) for a book.
 * It contains the name of the book and a list of sentence DTOs.
 * The class is annotated with the lombok @Data annotation, which automatically generates the getters and setters for the properties.
 */
@Data
public class BookDto {

    /**
     * The name variable stores the name of a book.
     */
    public String name;
    /**
     * The sentences variable is a List of SentenceDto objects.
     */
    public List<SentenceDto> sentences;

}
