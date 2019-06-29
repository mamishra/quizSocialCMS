package com.coviam.quizMedia.Statistics.dto;


import java.util.Map;

public class StateDto {

    private String stateId;
    private String userId;
    private String contestName;
    private String contestId;
    private Map<String, String> response;
    private String skipsUsed;

    public StateDto() {
    }

    public StateDto(String stateId, String userId, String contestName, String contestId, Map<String, String> response) {
        this.stateId = stateId;
        this.userId = userId;
        this.contestName = contestName;
        this.contestId = contestId;
        this.response = response;
    }

    public StateDto(String stateId, String userId, String contestName, String contestId, Map<String, String> response, String skipsUsed) {
        this.stateId = stateId;
        this.userId = userId;
        this.contestName = contestName;
        this.contestId = contestId;
        this.response = response;
        this.skipsUsed = skipsUsed;
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContestName() {
        return contestName;
    }

    public void setContestName(String contestName) {
        this.contestName = contestName;
    }

    public String getContestId() {
        return contestId;
    }

    public void setContestId(String contestId) {
        this.contestId = contestId;
    }

    public Map<String, String> getResponse() {
        return response;
    }

    public void setResponse(Map<String, String> response) {
        this.response = response;
    }

    public String getSkipsUsed() {
        return skipsUsed;
    }

    public void setSkipsUsed(String skipsUsed) {
        this.skipsUsed = skipsUsed;
    }

    @Override
    public String toString() {
        return "StateDto{" +
                "stateId='" + stateId + '\'' +
                ", userId='" + userId + '\'' +
                ", contestName='" + contestName + '\'' +
                ", contestId='" + contestId + '\'' +
                ", response=" + response +
                ", skipsUsed='" + skipsUsed + '\'' +
                '}';
    }
}
