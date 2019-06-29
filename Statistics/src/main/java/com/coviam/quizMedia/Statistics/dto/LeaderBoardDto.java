package com.coviam.quizMedia.Statistics.dto;

public class LeaderBoardDto implements Comparable{

    private String userId;
    private String userName;
    private int score;

    public LeaderBoardDto() {
    }

    public LeaderBoardDto(String userId, String userName, int score) {
        this.userId = userId;
        this.userName = userName;
        this.score = score;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "LeaderBoardDto{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        LeaderBoardDto leaderBoardDto= (LeaderBoardDto) o;
        if(score>leaderBoardDto.score)
            return -1;
        else return 1;
    }
}