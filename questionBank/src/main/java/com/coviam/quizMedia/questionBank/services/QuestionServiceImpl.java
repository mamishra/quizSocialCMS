package com.coviam.quizMedia.questionBank.services;

import com.coviam.quizMedia.questionBank.entity.CompositeKey;
import com.coviam.quizMedia.questionBank.entity.Question;
import com.coviam.quizMedia.questionBank.dto.QuestionDto;
import com.coviam.quizMedia.questionBank.entity.QuestionLog;
import com.coviam.quizMedia.questionBank.repository.QuestionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionRepository questionRepository;


    @Override
    public Question getQuestionByQueNo(String queNo) {
        return questionRepository.getQuestionByQueNo(queNo);
    }

    @Override
    public QuestionLog getQuestionListFromFile(String fileName) {



        QuestionLog qLog = new QuestionLog();
        int n = 0;
        int n1 = 0;
        qLog.setFileName(fileName);
        qLog.setTotalQuestions(n);

        String urlString = "https://drive.google.com/uc?export=view&id="+fileName;

        // create the url
        URL url = null;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        // open the url stream, wrap it in a few "readers"
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String line = "";
        String csvSplitBy = ",";
        try  {
            while (!(line = reader.readLine()).equals("END")) {

                // use comma as separator
                n = n + 1;
                String[] array = line.split(csvSplitBy);
                QuestionDto questionDto = new QuestionDto();
                CompositeKey cK = new CompositeKey();
                Question ques = new Question();
                questionDto.setQuestion(array[1]);
                questionDto.setOption1(array[2]);
                questionDto.setOption2(array[3]);
                questionDto.setOption3(array[4]);
                questionDto.setOption4(array[5]);
                questionDto.setRightAnswer(array[6]);
                questionDto.setAnswerType(array[7]);
                questionDto.setDifficultyLevel(array[8]);
                questionDto.setQuestionType(array[9]);
                questionDto.setBinaryPath(array[10]);
                questionDto.setCategory(array[11]);
                questionDto.setIsScreened(array[12]);
                questionDto.setIsRejected(array[13]);
                  BeanUtils.copyProperties(questionDto, ques);
                  cK.setQue(questionDto.getQuestion());
                  cK.setOp1(questionDto.getOption1());
                cK.setOp2(questionDto.getOption2());
                cK.setOp3(questionDto.getOption3());
                cK.setOp4(questionDto.getOption4());
                ques.setQuestion(cK);
            try {
                questionRepository.insert(ques);
                n1 = n1 + 1;
            } catch (Exception e) {
                continue;
            }
            }
        qLog.setTotalQuestions(n);
        qLog.setQuestionsAccepted(n1);
        qLog.setDuplicateQuestions(n-n1);
    }
        catch(IOException e) {
            e.printStackTrace();
        }

        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return qLog;
    }
        //return questionRepository.insert(ques);

    @Override
    public List<Question> getQuestionListByQuesNos(String[] queNoList) {

        List<Question> questionList = new ArrayList<>();
        for (String que : queNoList){
            Question question = questionRepository.getQuestionByQueNo(que);
            questionList.add(question);
        }
        return questionList;
    }

    @Override
    public List<Question> getQuestionByCategory(String category) {
        return questionRepository.getQuestionByCategory(category);
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

//    @Override
//    public List<Question> saveAllQuestionObject(List<Question> list) {
//        return questionRepository.save(list);
//    }

//    @Override
//    public List<String> deleteByIdCategory(String id, String category) {
//        List<Question> queList = questionRepository.getQuestionByCategory(category);
//        List<String> list = new ArrayList<>();
//        queList.forEach((que)->{
//            if (Integer.parseInt(que.getQueNo())<Integer.parseInt(id)){
//                list.add(que.getQueNo());
//                questionRepository.deleteQuestionByQueNo(que.getQueNo());
//            }
//        });
//        return list;
//    }

}
