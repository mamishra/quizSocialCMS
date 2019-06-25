package com.coviam.quizMedia.Statistics.services;

import com.coviam.quizMedia.Statistics.entity.Question;
import com.coviam.quizMedia.Statistics.entity.Score;
import com.coviam.quizMedia.Statistics.entity.State;
import com.coviam.quizMedia.Statistics.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        // Do any additional configuration here
        return builder.build();
    }

    @Autowired
    ScoreRepository scoreRepository;

    @Override
    public List<Score> getScoreByUserId(String userId) {
        return scoreRepository.getScoreByUserId(userId);
    }

    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<Score> fetchScore(State state) {
        List<Score> scoreList = scoreRepository.getScoreByContestId(state.getContestId());

        return scoreList;
    }

    @Override
    public List<Score> scoreByContestId(String contestId) {
        return scoreRepository.getScoreByContestId(contestId);
    }

    @Override
    public List<Score> saveScore(State state) {
        Map<String, String> response = state.getResponse();
        List<String> questionNoList = new ArrayList<>();
        for (Map.Entry<String, String> entry : response.entrySet()){
            questionNoList.add(entry.getKey());
        }
        List<String> answerList = new ArrayList<>();
        for (int i = 0; i < questionNoList.size(); i++){
            String queNo = questionNoList.get(i);
            String url = "http://localhost:9081/questionbank/getQuestion/"+queNo;
            restTemplate=new RestTemplate();
            Question question = restTemplate.getForObject(url, Question.class);
            answerList.add(question.getRightAnswer());
        }
        int points = 0;
        for (Map.Entry<String, String> entry : response.entrySet()){
            int i = 0;
            if (entry.getValue().equals(answerList.get(i))){
                points++;
            }
            i++;
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        Score score = new Score(state.getUserId(),state.getContestId(),state.getContestName(),points,date);
        List<Score> list = new ArrayList<>();
        list.add(score);
        List<Score> scoreList = scoreRepository.save(list);
        return scoreList;
    }
}
