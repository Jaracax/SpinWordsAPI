package com.example.SpinWordsAPI.Service;

import com.example.SpinWordsAPI.Entity.SentenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SentenceRepository extends JpaRepository<SentenceEntity,Integer> {

    @Query(value = "SELECT * FROM sentences WHERE LENGTH(original_sentence) > :length", nativeQuery = true)
    List<SentenceEntity> findByOriginalSentenceLengthGreaterThan(int length);
}
