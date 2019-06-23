package com.coviam.quizMedia.questionBank.repository;

import com.coviam.quizMedia.questionBank.entity.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends MongoRepository<Question,String> {
}
