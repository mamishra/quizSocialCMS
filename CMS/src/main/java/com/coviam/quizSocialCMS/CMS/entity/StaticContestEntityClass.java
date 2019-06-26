package com.coviam.quizSocialCMS.CMS.entity;

import com.coviam.quizSocialCMS.CMS.entityDto.ScreenedQuestionDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

@Document(collection = StaticContestEntityClass.COLLECTION_NAME)
public class StaticContestEntityClass {

    public final static String COLLECTION_NAME="staticContestCollection";

    @Id
    String contestId;
    String contestName;
    @Field(value = "questionId")
    List<ScreenedDataEntityClass> questionId;
    Date startTime;
    Date endTime;
    Date durationOfContest;
    String category;
    Date interval;
    boolean dynamicContest;
    boolean isActive;

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Date getInterval() {
        return interval;
    }

    public void setInterval(Date interval) {
        this.interval = interval;
    }

    public boolean isDynamicContest() {
        return dynamicContest;
    }

    public void setDynamicContest(boolean dynamicContest) {
        this.dynamicContest = dynamicContest;
    }

    public List<ScreenedDataEntityClass> getQuestionId() {
        return questionId;
    }

    public void setQuestionId(List<ScreenedDataEntityClass> questionId) {
        this.questionId = questionId;
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

//    public List<ScreenedDataEntityClass> getQuestionId() {
//        return questionId;
//    }
//
//    public void setQuestionId(List<ScreenedDataEntityClass> questionId) {
//        this.questionId = questionId;
//    }

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

    @Override
    public String toString() {
        return "StaticContestEntityClass{" +
                "contestId='" + contestId + '\'' +
                ", contestName='" + contestName + '\'' +
                ", questionId="  +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", durationOfContest=" + durationOfContest +
                ", category='" + category + '\'' +
                '}';
    }
}
