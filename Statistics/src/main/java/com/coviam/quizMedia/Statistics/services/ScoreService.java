package com.coviam.quizMedia.Statistics.services;

import com.coviam.quizMedia.Statistics.entity.Score;
import com.coviam.quizMedia.Statistics.entity.State;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ScoreService {

    List<Score> saveScore(State state);
    List<Score> fetchScore(State state);
}
