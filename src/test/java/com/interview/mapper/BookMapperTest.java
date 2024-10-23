package com.interview.mapper;

import com.interview.model.BookDto;
import com.interview.persistence.entity.Book;
import com.interview.util.TestUtils;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BookMapperTest {

    BookMapper mapper = new BookMapperImpl(new SentenceMapperImpl());

    @Test
    void dtoToEntity() {
        BookDto dto = TestUtils.createBookDto();
        Book book = mapper.dtoToEntity(dto);
        assertThat(book.getName()).isEqualTo(dto.getName());
        assertThat(book.getSentences().get(0).getValue()).isEqualTo(dto.getSentences().get(0).getValue());
        assertThat(book.getSentences().get(0).getWordCount()).isEqualTo(dto.getSentences().get(0).getWordCount());
    }
}