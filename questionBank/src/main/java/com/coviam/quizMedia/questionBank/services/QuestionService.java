package com.coviam.quizMedia.questionBank.services;

import com.coviam.quizMedia.questionBank.dto.QuestionDto;
import com.coviam.quizMedia.questionBank.entity.Question;
import com.coviam.quizMedia.questionBank.entity.QuestionLog;

import java.util.List;


public interface QuestionService {

    QuestionLog getQuestionListFromFile(String fileName);
    List<Question> getAllQuestions();
    List<Question> getQuestionByCategory(String category);
    Question getQuestionByQueNo(String queNo);
    List<Question> getQuestionListByQuesNos(String[] queNoList);
    //List<Question> saveAllQuestionObject(List<Question> list);
    //List<String> deleteByIdCategory(String id, String category);

}
