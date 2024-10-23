package com.interview.util;

import com.interview.model.BookDto;
import com.interview.model.CreateSingleSentenceRequest;
import com.interview.model.SentenceDto;
import com.interview.persistence.entity.Book;
import com.interview.persistence.entity.Sentence;

import java.util.ArrayList;
import java.util.List;

public class TestUtils {

    public static SentenceDto createSentenceDto() {
        SentenceDto dto = new SentenceDto();
        dto.setValue("this is sentence");
        dto.setWordCount(3);
        return dto;
    }

    public static BookDto createBookDto() {
        BookDto dto = new BookDto();
        dto.setName("name");
        dto.setSentences(List.of(createSentenceDto()));
        return dto;
    }

    public static Sentence createSentence() {
        return new Sentence("some sentence", 2, new Book("Book name", new ArrayList<>()));
    }

    public static Book createBookEntity() {
        return new Book("book name", List.of(createSentence()));
    }

    public static CreateSingleSentenceRequest getCreateSingleSentenceRequest() {
        CreateSingleSentenceRequest createSingleSentenceRequest = new CreateSingleSentenceRequest();
        createSingleSentenceRequest.setBookId("123");
        createSingleSentenceRequest.setValue("some sentence");
        createSingleSentenceRequest.setWordCount(2);
        return createSingleSentenceRequest;
    }
}
