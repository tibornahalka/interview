package com.interview.service;

import com.interview.mapper.SentenceMapper;
import com.interview.model.GroupedSentences;
import com.interview.persistence.entity.Sentence;
import com.interview.persistence.repository.SentenceRepository;
import com.interview.util.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SentenceServiceTest {

    SentenceService sentenceService;

    @Mock
    SentenceRepository sentenceRepository;

    @Mock
    SentenceMapper sentenceMapper;

    @Mock
    BookService bookService;

    @BeforeEach
    void setUp() {
        sentenceService = new SentenceService(sentenceRepository, sentenceMapper, bookService);
    }


    @Test
    void getWordCount() {
        Sentence sentence = TestUtils.createSentence();
        when(sentenceRepository.findById(any())).thenReturn(Optional.of(sentence));
        int wordCount = sentenceService.getWordCount("123");
        assertThat(wordCount).isEqualTo(sentence.getWordCount());
    }

    @Test
    void getAll() {
        Sentence sentence = TestUtils.createSentence();
        when(sentenceRepository.findAll()).thenReturn(List.of(sentence));
        List<GroupedSentences> all = sentenceService.getAll();
        assertThat(all.get(0).getBookId()).isEqualTo(sentence.getBook().getId());
        assertThat(all.get(0).getSentences().size()).isEqualTo(1);
    }

    @Test
    void createSingleSentence() {
        when(bookService.getBook(any())).thenReturn(TestUtils.createBookEntity());
        sentenceService.createSingleSentence(TestUtils.getCreateSingleSentenceRequest());
        verify(bookService, times(1)).getBook(any());
        verify(sentenceRepository, times(1)).save(any());
    }

}