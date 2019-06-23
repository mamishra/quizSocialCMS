package com.coviam.quizMedia.questionBank.services;

import com.coviam.quizMedia.questionBank.entity.Question;

import java.util.List;


public interface QuestionService {

    List<Question> getQuestionListFromFile(String fileName);
  //  List<Question> saveAllQuestions(List<Question> questionList);
    List<Question> getAllQuestions();
}
