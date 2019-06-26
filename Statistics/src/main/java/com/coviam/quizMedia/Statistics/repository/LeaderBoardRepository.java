package com.coviam.quizMedia.Statistics.repository;

import com.coviam.quizMedia.Statistics.entity.LeaderBoardEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaderBoardRepository extends MongoRepository<LeaderBoardEntity,String> {
}
