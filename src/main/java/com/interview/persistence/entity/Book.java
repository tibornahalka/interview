package com.interview.persistence.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Entity
public class Book extends EntityBase {

    @NotBlank
    @Length(max = 128)
    @Column(length = 128, nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @NotNull
    private List<Sentence> sentences;

    /**
     * Hibernate only
     */
    @Deprecated
    public Book() {
    }

    public Book(String name, List<Sentence> sentences) {
        this.name = name;
        this.sentences = sentences;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    public void setSentences(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return name.equals(book.name) && sentences.equals(book.sentences);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, sentences);
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", sentences=" + sentences +
                '}';
    }
}
