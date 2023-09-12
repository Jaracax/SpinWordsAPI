package com.example.SpinWordsAPI.Service;

import com.example.SpinWordsAPI.Entity.SentenceEntity;

public interface SentenceService {
    SentenceEntity reverseSentence(String originalSentence);
    SentenceEntity reverseSentenceEnhanced(String originalSentence, int length);

}
