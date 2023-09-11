package com.example.SpinWordsAPI.Service;

import com.example.SpinWordsAPI.Entity.SentenceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SentenceServiceImpl implements SentenceService{
    private final SentenceRepository sentenceRepository;

    @Autowired
    public SentenceServiceImpl(SentenceRepository sentenceRepository) {
        this.sentenceRepository = sentenceRepository;
    }

    @Override
    public SentenceEntity reverseSentence(String originalSentence) {
        String[] words = originalSentence.split("\\s");
        for (int i=0; i<words.length; i++) {
            if (words[i].length() >= 5) {
                words[i] = new StringBuilder(words[i]).reverse().toString();
            }
        }
        String reversedSentence = String.join(" ", words);

        SentenceEntity sentenceEntity = new SentenceEntity();
        sentenceEntity.setOriginalSentence(originalSentence);
        sentenceEntity.setReversedSentence(reversedSentence);
        sentenceRepository.save(sentenceEntity);
        return sentenceEntity;
    }
}
