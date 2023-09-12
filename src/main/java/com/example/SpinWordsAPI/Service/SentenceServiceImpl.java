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
        logicOfReversing(originalSentence,5);
        return saveSentence(originalSentence, logicOfReversing(originalSentence,5));
    }

    @Override
    public SentenceEntity reverseSentenceEnhanced(String originalSentence, int length) {
        logicOfReversing(originalSentence,length);
        return saveSentence(originalSentence,logicOfReversing(originalSentence,length));
    }

    public String logicOfReversing(String originalSentence, int length){
        String[] words = originalSentence.split("\\s");
        for (int i=0; i<words.length; i++) {
            if (words[i].length() >= length) {
                words[i] = new StringBuilder(words[i]).reverse().toString();
            }
        }
        return String.join(" ", words);
    }

    public SentenceEntity saveSentence(String originalSentence, String reversedSentence) {
        SentenceEntity sentenceEntity = new SentenceEntity();
        sentenceEntity.setOriginalSentence(originalSentence);
        sentenceEntity.setReversedSentence(reversedSentence);
        sentenceRepository.save(sentenceEntity);
        return sentenceEntity;
    }
}
