package com.interview.controller;

import com.interview.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
class BookControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    BookService bookService;

    @Test
    void createBook() throws Exception {
        mvc.perform(post("/book")
                        .contentType("application/json")
                        .content("{\n" +
                                "   \"name\":\"My Book2\",\n" +
                                "   \"sentences\":[\n" +
                                "      {\n" +
                                "         \"value\":\"This is the first sentence.\",\n" +
                                "         \"wordCount\":5\n" +
                                "      }\n" +
                                "   ]\n" +
                                "}"))
                .andExpect(status().isCreated());

        verify(bookService, times(1)).createBook(any());
    }
}