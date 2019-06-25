package com.coviam.quizMedia.Statistics.services;

import com.coviam.quizMedia.Statistics.entity.Score;
import com.coviam.quizMedia.Statistics.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class LeaderBoardServiceImpl implements LeaderBoardService {

    @Autowired
    ScoreRepository scoreRepository;

    @Autowired
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
    public String[] getAllUserId() {

        String url = "172.16.26.53:8081/getInfo";
        ResponseEntity<String[]> responseEntity = restTemplate.getForEntity(url, String[].class);
        String[] userIdList = responseEntity.getBody();
        return userIdList;
    }

    //........../getInfo/ get all user Ids
    @Override
    public String[] getUserNameArray(String[] userIds) {
        String url = "172.16.26.53:8081/getNames/"+userIds;
        restTemplate=new RestTemplate();
        ResponseEntity<String[]> responseEntity = restTemplate.getForEntity(url, String[].class);
        String[] userNameList = responseEntity.getBody();
        return userNameList;
    }
}
