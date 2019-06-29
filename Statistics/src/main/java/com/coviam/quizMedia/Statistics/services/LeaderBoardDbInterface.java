package com.coviam.quizMedia.Statistics.services;

import com.coviam.quizMedia.Statistics.dto.LeaderBoardDto;
import com.coviam.quizMedia.Statistics.entity.LeaderBoardEntity;

import java.util.List;

public interface LeaderBoardDbInterface {

    public LeaderBoardEntity save(LeaderBoardEntity leaderBoardEntity);
    public LeaderBoardEntity find(String id);

    public List<LeaderBoardEntity> findAll();
}
