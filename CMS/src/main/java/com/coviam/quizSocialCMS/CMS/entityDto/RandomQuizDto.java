package com.coviam.quizSocialCMS.CMS.entityDto;

import com.coviam.quizSocialCMS.CMS.entity.ScreenedDataEntityClass;
import com.coviam.quizSocialCMS.CMS.service.impl.ScreenedDataService;

import java.util.Date;
import java.util.List;

public class RandomQuizDto {
    String contestName;
    String contestId;
    ScreenedDataEntityClass questionId;
    String category;

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

    public ScreenedDataEntityClass getQuestionId() {
        return questionId;
    }

    public void setQuestionId(ScreenedDataEntityClass questionId) {
        this.questionId = questionId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
