package com.coviam.quizMedia.questionBank.services;

import com.coviam.quizMedia.questionBank.entity.Question;
import com.coviam.quizMedia.questionBank.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionRepository questionRepository;


    @Override
    public List<Question> getQuestionListFromFile(String fileName) {

        String csvFile = fileName;
        String line = "";
        String cvsSplitBy = ",";
        List<Question> questionList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while (!(line = br.readLine()).equals("")) {

                // use comma as separator

                String[] array = line.split(cvsSplitBy);
                Question question = new Question();

                question.setQueNo(array[0]);
                question.setQuestion(array[1]);
                question.setOption1(array[2]);
                question.setOption2(array[3]);
                question.setOption3(array[4]);
                question.setOption4(array[5]);
                question.setRightAnswer(array[6]);
                question.setAnswerType(array[7]);
                question.setDifficultyLevel(array[8]);
                question.setQuestionType(array[9]);
                question.setBinaryPath(array[10]);
                question.setCategory(array[11]);

                questionList.add(question);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return questionRepository.save(questionList);
    }


//    @Override
//    public List<Question> saveAllQuestions(List<Question> questionList) {
//
//        return questionRepository.save(questionList);
//    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }
}
