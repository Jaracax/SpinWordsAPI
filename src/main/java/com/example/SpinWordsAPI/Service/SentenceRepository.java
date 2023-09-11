package com.example.SpinWordsAPI.Service;

import com.example.SpinWordsAPI.Entity.SentenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SentenceRepository extends JpaRepository<SentenceEntity,Integer> {

}
