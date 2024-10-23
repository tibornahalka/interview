package com.interview.controller;

import com.interview.model.CreateSingleSentenceRequest;
import com.interview.model.GroupedSentences;
import com.interview.model.WordCountResponse;
import com.interview.service.SentenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The SentenceController class handles HTTP requests related to sentences.
 * It serves as the entry point for accessing and manipulating sentences in the system.
 * <p>
 * This class defines the endpoints for retrieving word count of a sentence,
 * retrieving all sentences grouped by book, and creating a new sentence.
 * <p>
 * The SentenceController class requires a SentenceService instance to handle the business logic
 * related to sentences.
 */
@RestController
@RequestMapping("/sentence")
@RequiredArgsConstructor
public class SentenceController {

    /**
     * The SentenceService class is responsible for handling the business logic related to sentences.
     * It provides methods for retrieving word count of a sentence, retrieving all sentences grouped by book,
     * and creating a new sentence.
     * <p>
     * The SentenceService class requires a SentenceRepository, SentenceMapper, and BookService instances to perform its operations.
     * It uses these dependencies to interact with the data layer and perform necessary mappings and transformations.
     */
    private final SentenceService sentenceService;

    /**
     * Retrieves the word count for a sentence based on the provided ID.
     *
     * @param id the ID of the sentence
     * @return a {@link WordCountResponse} object containing the word count
     */
    @GetMapping("/{id}/word-count")
    public WordCountResponse getWordCount(@PathVariable String id) {
        return WordCountResponse.builder()
                .wordCount(sentenceService.getWordCount(id))
                .build();
    }

    /**
     * Retrieves all sentences grouped by book.
     *
     * @return a list of GroupedSentences objects representing all sentences grouped by book
     */
    @GetMapping("/all")
    public List<GroupedSentences> getAll() {
        return sentenceService.getAll();
    }

    /**
     * Creates a new single sentence.
     *
     * @param request the request to create a new single sentence
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createSingleSentence(@RequestBody CreateSingleSentenceRequest request) {
        sentenceService.createSingleSentence(request);
    }

}