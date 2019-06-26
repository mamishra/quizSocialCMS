package com.coviam.quizMedia.Statistics.services.impl;

import com.coviam.quizMedia.Statistics.dto.LeaderBoardDto;
import com.coviam.quizMedia.Statistics.entity.LeaderBoardEntity;
import com.coviam.quizMedia.Statistics.entity.Score;
import com.coviam.quizMedia.Statistics.repository.LeaderBoardRepository;
import com.coviam.quizMedia.Statistics.services.LeaderBoardDbInterface;
import com.coviam.quizMedia.Statistics.services.LeaderBoardService;
import com.coviam.quizMedia.Statistics.services.ScoreService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LeaderBoardDbService implements LeaderBoardDbInterface {

    @Autowired
    LeaderBoardRepository leaderBoardRepository;


    @Override
    public LeaderBoardEntity save(LeaderBoardEntity leaderBoardEntity) {
        return leaderBoardRepository.save(leaderBoardEntity);
    }

    @Override
    public LeaderBoardEntity find(String id) {
        return leaderBoardRepository.findOne(id);
    }


}
