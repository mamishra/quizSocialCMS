package com.coviam.quizMedia.Statistics.services;

import com.coviam.quizMedia.Statistics.entity.Score;

import java.util.List;

public interface LeaderBoardService {

    List<Score> getDailyLeaderBoard(String contestId);
    List<Score> getWeeklyLeaderBoard(String contestId);
    List<Score> getGlobalLeaderBoardPerContest(String contestId);
    //List<Score> getUserLeaderBoard(String userId);
    String[] getUserNameArray(String[] userIds);
    String[] getAllUserId();
}
