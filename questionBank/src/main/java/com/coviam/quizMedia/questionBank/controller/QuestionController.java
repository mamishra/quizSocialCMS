package com.coviam.quizMedia.questionBank.controller;

import com.coviam.quizMedia.questionBank.dto.QuestionDto;
import com.coviam.quizMedia.questionBank.entity.Question;
import com.coviam.quizMedia.questionBank.services.QuestionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/questionbank")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @RequestMapping(method = RequestMethod.POST, value = "/saveAll")
    public ResponseEntity<?> saveAllQuestions(@RequestBody String fileName){

        List<Question> questionList = questionService.getQuestionListFromFile(fileName);
        List<QuestionDto> questionDtoList = new ArrayList<>();
        questionList.forEach((que)->{
            QuestionDto questionDto = new QuestionDto();
            BeanUtils.copyProperties(que, questionDto);
            questionDtoList.add(questionDto);
        });

        return new ResponseEntity<List<QuestionDto>>( questionDtoList,HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.GET, value = "/getAll")
    public ResponseEntity<?> getAllQuestions(){

        List<Question> questionList = questionService.getAllQuestions();
        List<QuestionDto> questionDtoList = new ArrayList<>();
        questionList.forEach((que)->{
            QuestionDto questionDto = new QuestionDto();
            BeanUtils.copyProperties(que, questionDto);
            questionDtoList.add(questionDto);
        });

        return new ResponseEntity<List<QuestionDto>>(questionDtoList,HttpStatus.OK);
    }


}
