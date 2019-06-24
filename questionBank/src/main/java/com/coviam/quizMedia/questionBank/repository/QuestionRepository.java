package com.coviam.quizMedia.questionBank.repository;

import com.coviam.quizMedia.questionBank.entity.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends MongoRepository<Question,String> {

    List<Question> getQuestionByCategory(String category);
    Long deleteQuestionByQueNo(String id);
    Question getQuestionByQueNo(String queNo);
}
