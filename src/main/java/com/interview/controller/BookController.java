package com.interview.controller;

import com.interview.model.BookDto;
import com.interview.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for managing books.
 */
@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    /**
     * Represents a service for managing books.
     */
    private final BookService bookService;

    /**
     * This method is used to create a new book.
     *
     * @param bookDto The BookDto object representing the details of the book to be created.
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createBook(@RequestBody BookDto bookDto) {
        bookService.createBook(bookDto);
    }

}