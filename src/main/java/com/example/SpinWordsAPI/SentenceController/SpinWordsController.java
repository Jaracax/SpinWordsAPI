package com.example.SpinWordsAPI.SentenceController;

import com.example.SpinWordsAPI.Entity.SentenceEntity;
import com.example.SpinWordsAPI.Service.SentenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SpinWordsController {

    private final SentenceRepository sentenceRepository;

    @Autowired
    public SpinWordsController(SentenceRepository sentenceRepository) {
        this.sentenceRepository = sentenceRepository;
    }

    @PostMapping("/spinning")
    public SentenceEntity spinWords(@RequestBody SentenceEntity request) {
        String originalSentence = request.getOriginalSentence();
        String[] words = originalSentence.split("\\s");
        for (int i=0; i<words.length; i++) {
            if (words[i].length() >= 5) {
                words[i] = new StringBuilder(words[i]).reverse().toString();
            }
        }
        String reversedSentence = String.join(" ", words);
        
        // Save the original and reversed sentences to the database
        //return String.join(" ",words);
        SentenceEntity sentenceEntity = new SentenceEntity();
        sentenceEntity.setOriginalSentence(originalSentence);
        sentenceEntity.setReversedSentence(reversedSentence);
        sentenceRepository.save(sentenceEntity);
        return sentenceEntity;
    }

    @GetMapping("/")
    public List<SentenceEntity> getAllSentences(){
        return sentenceRepository.findAll();
    }
}
