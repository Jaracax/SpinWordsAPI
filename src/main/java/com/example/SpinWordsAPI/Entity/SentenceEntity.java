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

    public SentenceEntity() {
    }

    public SentenceEntity(String originalSentence) {
        this.originalSentence = originalSentence;
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
                '}';
    }
}
