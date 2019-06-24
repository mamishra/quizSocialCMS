package com.coviam.quizMedia.Statistics.dto;

import java.util.Date;

public class ScoreDto {

    private String scoreId;
    private String userId;
    private String contestId;
    private String contestName;
    private int points;
    private Date timeStamp;

    public ScoreDto() {
    }

    public ScoreDto(String scoreId, String userId, String contestId, String contestName, int points, Date timeStamp) {
        this.scoreId = scoreId;
        this.userId = userId;
        this.contestId = contestId;
        this.contestName = contestName;
        this.points = points;
        this.timeStamp = timeStamp;
    }

    public String getScoreId() {
        return scoreId;
    }

    public void setScoreId(String scoreId) {
        this.scoreId = scoreId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContestId() {
        return contestId;
    }

    public void setContestId(String contestId) {
        this.contestId = contestId;
    }

    public String getContestName() {
        return contestName;
    }

    public void setContestName(String contestName) {
        this.contestName = contestName;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "ScoreDto{" +
                "scoreId='" + scoreId + '\'' +
                ", userId='" + userId + '\'' +
                ", contestId='" + contestId + '\'' +
                ", contestName='" + contestName + '\'' +
                ", points=" + points +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
