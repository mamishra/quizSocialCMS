package com.coviam.quizMedia.Statistics.repository;

import com.coviam.quizMedia.Statistics.entity.State;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateRepository extends MongoRepository<State,String> {
    //boolean insert(State state);
    List<State> findByContestId(String contestId);
}
