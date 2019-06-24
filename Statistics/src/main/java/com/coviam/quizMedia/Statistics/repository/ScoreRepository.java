package com.coviam.quizMedia.Statistics.repository;

import com.coviam.quizMedia.Statistics.entity.Question;
import com.coviam.quizMedia.Statistics.entity.Score;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository extends MongoRepository<Score, String> {
    List<Score> getScoreByContestId(String contestId);
}
