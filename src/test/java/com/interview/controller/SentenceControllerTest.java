package com.interview.controller;

import com.interview.model.GroupedSentences;
import com.interview.service.SentenceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SentenceController.class)
class SentenceControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    SentenceService sentenceService;

    @Test
    void getWordCount() throws Exception {
        when(sentenceService.getWordCount("123")).thenReturn(3);
        mvc.perform(get("/sentence/123/word-count"))
                .andExpect(jsonPath("$.wordCount").value("3"))
                .andExpect(status().isOk());

        verify(sentenceService, times(1)).getWordCount("123");
    }

    @Test
    void getAll() throws Exception {
        when(sentenceService.getAll()).thenReturn(List.of(GroupedSentences.builder().build()));
        mvc.perform(get("/sentence/all"))
                .andExpect(status().isOk());

        verify(sentenceService, times(1)).getAll();
    }

    @Test
    void createSingleSentence() throws Exception {
        mvc.perform(post("/sentence")
                        .contentType("application/json")
                        .content("{\n" +
                                "    \"bookId\": \"4714e9c5-1904-4d70-b1b8-ec9148944f94\",\n" +
                                "    \"value\": \"This is a sentence from the book.\",\n" +
                                "    \"wordCount\": 6\n" +
                                "}"))
                .andExpect(status().isCreated());

        verify(sentenceService, times(1)).createSingleSentence(any());
    }
}