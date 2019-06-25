package com.coviam.quizSocialCMS.CMS.entityDto;

import java.util.Date;
import java.util.List;

public class ActiveContestDto {
    String contestId;
    String contestName;
    Date startTime;
    Date endTime;
    Date durationOfContest;
    String category;
    boolean dynamicContest;

    public boolean isDynamicContest() {
        return dynamicContest;
    }

    public void setDynamicContest(boolean dynamicContest) {
        this.dynamicContest = dynamicContest;
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
