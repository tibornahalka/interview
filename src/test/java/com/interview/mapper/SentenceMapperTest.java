package com.interview.mapper;

import com.interview.model.SentenceDto;
import com.interview.persistence.entity.Sentence;
import com.interview.util.TestUtils;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SentenceMapperTest {

    SentenceMapper mapper = new SentenceMapperImpl();

    @Test
    void entityToDto() {
        Sentence sentence = TestUtils.createSentence();
        SentenceDto dto = mapper.entityToDto(sentence);
        assertThat(dto.getValue()).isEqualTo(sentence.getValue());
        assertThat(dto.getWordCount()).isEqualTo(sentence.getWordCount());
    }

    @Test
    void dtoToEntity() {
        SentenceDto dto = TestUtils.createSentenceDto();
        Sentence sentence = mapper.dtoToEntity(dto);
        assertThat(sentence.getValue()).isEqualTo(dto.getValue());
        assertThat(sentence.getWordCount()).isEqualTo(dto.getWordCount());

    }
}