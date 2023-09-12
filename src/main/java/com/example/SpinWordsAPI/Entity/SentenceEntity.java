package com.example.SpinWordsAPI.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sentences")
public class SentenceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "original_sentence")
    private String originalSentence;
    @Column(name = "reversed_sentence")
    private String reversedSentence;

    @Transient
    private Integer length;

    public SentenceEntity() {
    }

    public SentenceEntity(String originalSentence, int length) {
        this.originalSentence = originalSentence;
        this.length = length;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOriginalSentence() {
        return originalSentence;
    }

    public void setOriginalSentence(String originalSentence) {
        this.originalSentence = originalSentence;
    }

    public String getReversedSentence() {
        return reversedSentence;
    }

    public void setReversedSentence(String reversedSentence) {
        this.reversedSentence = reversedSentence;
    }

    @Override
    public String toString() {
        return "SentenceEntity{" +
                "id=" + id +
                ", originalSentence='" + originalSentence + '\'' +
                ", reversedSentence='" + reversedSentence + '\'' +
                ", length=" + length +
                '}';
    }
}
