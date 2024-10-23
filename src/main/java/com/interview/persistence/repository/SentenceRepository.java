package com.interview.persistence.repository;

import java.util.List;

import com.interview.persistence.entity.Sentence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface SentenceRepository extends JpaRepository<Sentence, String> {

    @Transactional(propagation = Propagation.REQUIRED)
    List<Sentence> getAllByBookId(String bookId);
}
