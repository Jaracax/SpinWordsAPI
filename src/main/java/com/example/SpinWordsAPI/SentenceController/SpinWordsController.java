package com.example.SpinWordsAPI.SentenceController;

import com.example.SpinWordsAPI.Entity.SentenceEntity;
import com.example.SpinWordsAPI.Service.SentenceRepository;
import com.example.SpinWordsAPI.Service.SentenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SpinWordsController {

    private final SentenceService sentenceService;
    private final SentenceRepository sentenceRepository;

    @Autowired
    public SpinWordsController(SentenceService sentenceService, SentenceRepository sentenceRepository) {
        this.sentenceService = sentenceService;
        this.sentenceRepository = sentenceRepository;
    }

    @PostMapping("/spinning")
    public SentenceEntity spinWords(@RequestBody SentenceEntity request) {
        String originalSentence = request.getOriginalSentence();
        return sentenceService.reverseSentence(originalSentence);
    }

    @PostMapping("/spinning-enhanced")
    public SentenceEntity spinWordsEnhanced(@RequestBody SentenceEntity requestSentence) {
        String originalSentence = requestSentence.getOriginalSentence();
        Integer length = requestSentence.getLength();
        if (length == null){
            length = 5;
            System.out.println("Length was not specified, setting it to a default of 5");
        }
        return sentenceService.reverseSentenceEnhanced(originalSentence,length);
    }

    @GetMapping("/long-sentences/{length}")
    public List<SentenceEntity> getLongSentences(@PathVariable int length){
        // This gives you back the sentences counting the characters
        // In other words length = characters
        return sentenceRepository.findByOriginalSentenceLengthGreaterThan(length);
    }


}
