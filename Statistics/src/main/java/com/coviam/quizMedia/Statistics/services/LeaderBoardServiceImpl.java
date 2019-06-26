package com.coviam.quizMedia.Statistics.services;

import com.coviam.quizMedia.Statistics.entity.Score;
import com.coviam.quizMedia.Statistics.repository.ScoreRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class LeaderBoardServiceImpl implements LeaderBoardService {

    @Bean
    public RestTemplate restTemplate(@Lazy RestTemplateBuilder builder) {
        // Do any additional configuration here
        return builder.build();
    }

    @Autowired
    ScoreRepository scoreRepository;


    @Autowired
    @Lazy
    RestTemplate restTemplate;

    @Override
    public List<Score> getDailyLeaderBoard(String contestId) {
        return null;
    }

    @Override
    public List<Score> getWeeklyLeaderBoard(String contestId) {
        return null;
    }

    @Override
    public List<Score> getGlobalLeaderBoardPerContest(String contestId) {
        return scoreRepository.getScoreByContestId(contestId);
    }

    @Override
    public List<String> getAllUserId() {

        String url = "http://172.16.26.53:8081/getIds";
        restTemplate=new RestTemplate();

        ArrayList listResponseEntity=restTemplate.getForObject(url,ArrayList.class);
        return listResponseEntity;
//        ResponseEntity<List<String>> response = restTemplate.exchange("172.16.26.53:8081/getIds", HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>(){});
//        List<String> userIdList = response.getBody();
//        return userIdList;
    }

    //........../getInfo/ get all user Ids
    @Override
    public List<String> getUserNameList(List<String> userIds) {
        String url = "http://172.16.26.53:8081/getOnlyNames";
        restTemplate=new RestTemplate();
        ResponseEntity<ArrayList> listResponseEntity=restTemplate.postForEntity(url, (Object) userIds, ArrayList.class);
        ArrayList<String> list=listResponseEntity.getBody();
        return list;
    }
}
