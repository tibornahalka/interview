package com.interview.service;

import com.interview.exceptions.RecordNotFoundException;
import com.interview.mapper.SentenceMapper;
import com.interview.model.CreateSingleSentenceRequest;
import com.interview.model.GroupedSentences;
import com.interview.model.SentenceDto;
import com.interview.persistence.entity.Book;
import com.interview.persistence.entity.Sentence;
import com.interview.persistence.repository.SentenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The SentenceService class provides functionality for managing and retrieving sentences.
 */
@Service
@RequiredArgsConstructor
public class SentenceService {

    /**
     * The SentenceRepository is an interface that extends the JpaRepository.
     * It provides methods for accessing and manipulating Sentence entities in the database.
     */
    private final SentenceRepository sentenceRepository;

    /**
     * The SentenceMapper class is responsible for mapping between Sentence and SentenceDto objects.
     * It provides methods for converting Sentence entity objects to SentenceDto objects and vice versa.
     */
    private final SentenceMapper sentenceMapper;

    /**
     * The BookService class is responsible for managing books, including retrieving a book by its ID and creating new books.
     */
    private final BookService bookService;

    /**
     * Retrieves the word count of a sentence based on the provided sentence ID.
     *
     * @param sentenceId the ID of the sentence
     * @return the word count of the sentence
     * @throws RecordNotFoundException if the sentence with the provided ID is not found
     */
    public int getWordCount(String sentenceId) {
        Sentence sentence = sentenceRepository.findById(sentenceId)
                .orElseThrow(() -> new RecordNotFoundException("Sentence with provided ID=" + sentenceId + " not found."));
        return sentence.getWordCount();
    }

    /**
     * Retrieves all sentences grouped by book.
     *
     * @return a list of GroupedSentences objects representing all sentences grouped by book
     */
    public List<GroupedSentences> getAll() {
        List<Sentence> all = sentenceRepository.findAll();
        Map<String, List<SentenceDto>> groupedByBookId = getAllGroupedByBookId(all);
        List<GroupedSentences> response = new ArrayList<>();
        for (Map.Entry<String, List<SentenceDto>> entry : groupedByBookId.entrySet()) {
            GroupedSentences groupedSentences = GroupedSentences.builder()
                    .bookId(entry.getKey())
                    .sentences(entry.getValue())
                    .build();
            response.add(groupedSentences);
        }
        return response;
    }

    /**
     * This method takes a list of Sentence objects as input and groups them by their associated book ID.
     *
     * @param sentences A list of Sentence objects to be grouped by book ID.
     * @return A map containing lists of SentenceDto objects, where each list is grouped by book ID.
     */
    private Map<String, List<SentenceDto>> getAllGroupedByBookId(List<Sentence> sentences) {
        Map<String, List<SentenceDto>> sentencesGroupedByBookId = new HashMap<>();
        for (Sentence sentence : sentences) {
            String bookId = sentence.getBook().getId();
            if (sentencesGroupedByBookId.containsKey(bookId)) {
                sentencesGroupedByBookId.get(bookId).add(sentenceMapper.entityToDto(sentence));
            } else {
                List<SentenceDto> bookSentences = new ArrayList<>();
                bookSentences.add(sentenceMapper.entityToDto(sentence));
                sentencesGroupedByBookId.put(bookId, bookSentences);
            }
        }
        return sentencesGroupedByBookId;
    }


    /**
     * Creates a new single sentence.
     *
     * @param request the request to create a new single sentence
     */
    public void createSingleSentence(CreateSingleSentenceRequest request) {
        Book book = bookService.getBook(request.getBookId());
        Sentence sentence = new Sentence(request.getValue(), request.getWordCount(), book);
        sentenceRepository.save(sentence);
    }
}
