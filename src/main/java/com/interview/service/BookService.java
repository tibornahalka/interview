package com.interview.service;

import com.interview.exceptions.RecordNotFoundException;
import com.interview.mapper.BookMapper;
import com.interview.model.BookDto;
import com.interview.persistence.entity.Book;
import com.interview.persistence.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * The BookService class is responsible for managing books, including retrieving a book by its ID and creating new books.
 */
@Service
@RequiredArgsConstructor
public class BookService {

    /**
     * The bookRepository variable is an instance of the BookRepository interface.
     * It is responsible for accessing and manipulating the book data in the database.
     */
    private final BookRepository bookRepository;

    /**
     * The private final variable 'bookMapper' is an instance of the BookMapper class and is responsible for mapping between BookDto and Book entities.
     * It is used in the BookService class to convert BookDto objects to Book entities.
     * <p>
     * The BookMapper class is annotated with the @Mapper annotation and defines several methods for converting between BookDto and Book objects.
     * The 'dtoToEntity' method in the BookMapper class converts a BookDto object to a Book entity.
     */
    private final BookMapper bookMapper;

    /**
     * Retrieves a book from the book repository based on its ID.
     *
     * @param bookId The ID of the book to retrieve.
     * @return The book with the specified ID if found, otherwise throws a RecordNotFoundException.
     */
    public Book getBook(String bookId) {
        return bookRepository.findById(bookId).orElseThrow(() -> new RecordNotFoundException("Book with ID=" + bookId + " not found;"));
    }

    /**
     * Creates a new book with the provided bookDTO.
     *
     * @param bookDto The BookDto object representing the details of the book to be created.
     */
    public void createBook(BookDto bookDto) {
        Book book = bookMapper.dtoToEntity(bookDto);
        //set book for all sentences
        book.getSentences().forEach(sentence -> sentence.setBook(book));
        bookRepository.save(book);
    }
}
