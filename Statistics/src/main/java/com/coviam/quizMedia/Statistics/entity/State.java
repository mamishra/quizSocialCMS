package com.coviam.quizMedia.Statistics.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document
public class  State {

    @Id
    private String stateId;

    private String userId;
    private String contestName;
    private String contestId;
    private Map<String, String> response;

    public State() {
    }

    public State(String stateId, String userId, String contestName, String contestId, Map<String, String> response) {
        this.stateId = stateId;
        this.userId = userId;
        this.contestName = contestName;
        this.contestId = contestId;
        this.response = response;
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

    @Override
    public String toString() {
        return "State{" +
                "stateId='" + stateId + '\'' +
                ", userId='" + userId + '\'' +
                ", contestName='" + contestName + '\'' +
                ", contestId='" + contestId + '\'' +
                ", response=" + response +
                '}';
    }
}
