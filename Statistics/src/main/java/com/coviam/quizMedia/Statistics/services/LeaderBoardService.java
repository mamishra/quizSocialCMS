package com.coviam.quizMedia.Statistics.services;

import com.coviam.quizMedia.Statistics.entity.Score;

import java.util.ArrayList;
import java.util.List;

public interface LeaderBoardService {

    List<Score> getDailyLeaderBoard(String contestId);
    List<Score> getWeeklyLeaderBoard(String contestId);
    List<Score> getGlobalLeaderBoardPerContest(String contestId);
    //List<Score> getUserLeaderBoard(String userId);
    List<String> getUserNameList(List<String> userIds);
    List<String> getAllUserId();
}
