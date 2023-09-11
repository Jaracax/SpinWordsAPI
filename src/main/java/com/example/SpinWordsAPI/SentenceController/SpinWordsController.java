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

    @GetMapping("/long-sentences/{length}")
    public List<SentenceEntity> getLongSentences(@PathVariable int length){
        return sentenceRepository.findByOriginalSentenceLengthGreaterThan(length);
    }


}
