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
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/questionbank")
@CrossOrigin("*")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @RequestMapping(method = RequestMethod.POST, value = "/saveAll")
    public ResponseEntity<?> saveAllQuestions(@RequestBody String fileName){

        try {
            List<Question> questionList = questionService.getQuestionListFromFile(fileName);
            List<QuestionDto> questionDtoList = new ArrayList<>();
            questionList.forEach((que) -> {
                QuestionDto questionDto = new QuestionDto();
                BeanUtils.copyProperties(que, questionDto);
                questionDtoList.add(questionDto);
            });

            return new ResponseEntity<String>("{\"msg\":\"saved\"}", HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<String>("{\"err\":\"error saving\"}", HttpStatus.OK);

        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveAllQuestions")
    public ResponseEntity<?> saveAllQuestionsObject(@RequestBody List<Question> list) {

        try {
            List<Question> questionList = questionService.saveAllQuestionObject(list);
            List<QuestionDto> questionDtoList = new ArrayList<>();
            questionList.forEach((que) -> {
                QuestionDto questionDto = new QuestionDto();
                BeanUtils.copyProperties(que, questionDto);
                questionDtoList.add(questionDto);
            });

            return new ResponseEntity<List<QuestionDto>>(questionDtoList, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<String>("{\"err\":\"error saving\"}", HttpStatus.OK);

        }

    }

    @RequestMapping(method = RequestMethod.GET, value = "/getAll")
    public ResponseEntity<?> getAllQuestions(){

        try{
            List<Question> questionList = questionService.getAllQuestions();
            List<QuestionDto> questionDtoList = new ArrayList<>();
            questionList.forEach((que)->{
                QuestionDto questionDto = new QuestionDto();
                BeanUtils.copyProperties(que, questionDto);
                questionDtoList.add(questionDto);
            });

            return new ResponseEntity<List<QuestionDto>>(questionDtoList,HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<String>("{\"err\":\"error fetching\"}", HttpStatus.OK);

        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getAll/{category}")
    public ResponseEntity<?> getquestionByCategory(@PathVariable("category") String category){

        System.out.println("Recieving request"+new Date());
        try {
            List<Question> questionList = questionService.getQuestionByCategory(category);
            questionList.addAll(new ArrayList<Question>(questionService.getQuestionByCategory(category.toLowerCase())));
            List<QuestionDto> questionDtoList = new ArrayList<>();
            questionList.forEach((que) -> {
                QuestionDto questionDto = new QuestionDto();
                BeanUtils.copyProperties(que, questionDto);
                questionDtoList.add(questionDto);
            });
            System.out.println("Sending response"+new Date());

            return new ResponseEntity<List<QuestionDto>>(questionDtoList, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<String>("{\"err\":\"error fetching\"}", HttpStatus.OK);

        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getQuestion/{queNo}")
    public ResponseEntity<?> getQuestionByQueNo(@PathVariable("queNo") String queNo) {

        try{

            Question question = questionService.getQuestionByQueNo(queNo);
            QuestionDto questionDto = new QuestionDto();
            BeanUtils.copyProperties(question, questionDto);

            return new ResponseEntity<QuestionDto>(questionDto, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<String>("{\"err\":\"error getting question\"}", HttpStatus.OK);

        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getQuestionList")
    public ResponseEntity<?> getQuestionListByQueNos(@RequestBody String[] queNoList) {

        try{

            List<Question> questionList = questionService.getQuestionListByQuesNos(queNoList);
            List<QuestionDto> questionDtoList = new ArrayList<>();
            questionList.forEach((que) -> {
                QuestionDto questionDto = new QuestionDto();
                BeanUtils.copyProperties(que, questionDto);
                questionDtoList.add(questionDto);
            });

            return new ResponseEntity<List<QuestionDto>>(questionDtoList, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<String>("{\"err\":\"error getting question\"}", HttpStatus.OK);

        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    public ResponseEntity<?> getquestionByCategory(@RequestParam(name = "queNo") String queNo, @RequestParam(name = "category") String category){

        try {
            List<String> list = questionService.deleteByIdCategory(queNo, category);


            return new ResponseEntity<List<String>>(list, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<String>("{\"err\":\"error in deleting\"}", HttpStatus.OK);

        }
    }


}
