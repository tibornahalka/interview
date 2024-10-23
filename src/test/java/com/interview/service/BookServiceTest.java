package com.interview.service;

import com.interview.mapper.BookMapper;
import com.interview.persistence.entity.Book;
import com.interview.persistence.repository.BookRepository;
import com.interview.util.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    BookService bookService;

    @Mock
    BookRepository bookRepository;

    @Mock
    BookMapper bookMapper;

    @BeforeEach
    void setUp() {
        bookService = new BookService(bookRepository, bookMapper);
    }


    @Test
    void getBook() {
        String bookId = "123";
        when(bookRepository.findById(bookId)).thenReturn(Optional.of(new Book()));
        Book book = bookService.getBook(bookId);
        assertThat(book).isNotNull();
        verify(bookRepository, times(1)).findById(bookId);
    }

    @Test
    void createBook() {
        when(bookMapper.dtoToEntity(any())).thenReturn(TestUtils.createBookEntity());
        bookService.createBook(TestUtils.createBookDto());
        verify(bookMapper, times(1)).dtoToEntity(any());
        verify(bookRepository, times(1)).save(any());
    }
}