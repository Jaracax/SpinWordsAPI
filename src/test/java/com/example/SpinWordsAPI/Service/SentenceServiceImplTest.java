package com.example.SpinWordsAPI.Service;

import com.example.SpinWordsAPI.Entity.SentenceEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class SentenceServiceImplTest {

    @Mock
    private SentenceRepository sentenceRepository;

    private SentenceServiceImpl sentenceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        sentenceService = new SentenceServiceImpl(sentenceRepository);
    }

    @Nested
    class reversedLogicTests {

        @Test
        void lengthOfOne() {
            // Given
            String originalSentence = "Reversing words that are one characters or more";
            int length = 1;

            // When
            String reversedSentence = sentenceService.logicOfReversing(originalSentence, length);

            // Assert
            assertEquals("gnisreveR sdrow taht era eno sretcarahc ro erom", reversedSentence);
        }

        @Test
        void lengthOfThree() {
            // Given
            String originalSentence = "Reversing words that are four characters or more";
            int length = 4;

            // When
            String reversedSentence = sentenceService.logicOfReversing(originalSentence, length);

            // Assert
            assertEquals("gnisreveR sdrow taht are ruof sretcarahc or erom", reversedSentence);
        }

        @Test
        void lengthOfFive() {
            // Given
            String originalSentence = "Reversing words that are five characters or more";
            int length = 5;

            // When
            String reversedSentence = sentenceService.logicOfReversing(originalSentence, length);

            // Assert
            assertEquals("gnisreveR sdrow that are five sretcarahc or more", reversedSentence);
        }

        @Test
        void lengthOfSeven(){
            // Given
            String originalSentence = "Reversing words that are seven characters or more";
            int length = 7;

            // When
            String reversedSentence = sentenceService.logicOfReversing(originalSentence,length);

            // Then
            assertEquals("gnisreveR words that are seven sretcarahc or more",reversedSentence);
        }
    }


    @Test
    void testSaveSentence() {
        // Given
        String originalSentence = "Hello world";
        String reversedSentence = "olleH dlrow";

        // Mock the sentenceRepository's save method
        SentenceEntity savedEntity = new SentenceEntity();
        when(sentenceRepository.save(any())).thenReturn(savedEntity);

        // When
        SentenceEntity result = sentenceService.saveSentence(originalSentence, reversedSentence);

        // Assert
        assertEquals(originalSentence, result.getOriginalSentence());
        assertEquals(reversedSentence, result.getReversedSentence());

        // Verify that the save method was called
        verify(sentenceRepository, times(1)).save(any());
    }

}