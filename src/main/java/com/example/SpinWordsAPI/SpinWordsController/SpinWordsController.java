package com.example.SpinWordsAPI.SpinWordsController;

import com.example.SpinWordsAPI.SentenceRequest.SentenceRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpinWordsController {

    @PostMapping("spinning")
    public String spinWords(@RequestBody SentenceRequest request) {
        String sentence = request.getSentence();
        String[] words = sentence.split("\\s");
        for (int i=0; i<words.length; i++) {
            if (words[i].length() >= 5) {
                words[i] = new StringBuilder(words[i]).reverse().toString();
            }
        }
        return String.join(" ",words);
    }
}
