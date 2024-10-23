package com.interview.persistence.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Sentence extends EntityBase {

    @ManyToOne
    @NotNull
    private Book book;

    @NotNull
    @Length(max = 128)
    @Column(length = 128, nullable = false)
    private String value;

    @NotNull
    @Column(nullable = false)
    private Integer wordCount;

    /**
     * Hibernate only
     */
    @Deprecated
    public Sentence() {
    }

    public Sentence(String value, Integer wordCount, Book book) {
        this.value = value;
        this.wordCount = wordCount;
        this.book = book;

    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getWordCount() {
        return wordCount;
    }

    public void setWordCount(Integer wordCount) {
        this.wordCount = wordCount;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Sentence sentence = (Sentence) o;
        return value.equals(sentence.value) && wordCount.equals(sentence.wordCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), value, wordCount);
    }

    @Override
    public String toString() {
        return "Sentence{" +
                "value='" + value + '\'' +
                ", wordCount=" + wordCount +
                '}';
    }
}
