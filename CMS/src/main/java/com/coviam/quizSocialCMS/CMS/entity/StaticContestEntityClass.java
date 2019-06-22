package com.coviam.quizSocialCMS.CMS.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Document(collection = StaticContestEntityClass.COLLECTION_NAME)
public class StaticContestEntityClass {

    public final static String COLLECTION_NAME="staticContestCollection";

    @Id
    String contestId;
    String contestName;
    String questionId[];
    Date startTime;
    Date endTime;
    Date durationOfContest;
    String category;

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

    public String[] getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String[] questionId) {
        this.questionId = questionId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getDurationOfContest() {
        return durationOfContest;
    }

    public void setDurationOfContest(Date durationOfContest) {
        this.durationOfContest = durationOfContest;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
