package com.coviam.quizSocialCMS.CMS.entityDto;

import com.coviam.quizSocialCMS.CMS.entity.ScreenedDataEntityClass;

import java.util.Date;
import java.util.List;

public class StaticContestDto {
    String contestName;
    String contestId;
    List<ScreenedQuestionDto> questionId;
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

    public List<ScreenedQuestionDto> getQuestionId() {
        return questionId;
    }

    public void setQuestionId(List<ScreenedQuestionDto> questionId) {
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
