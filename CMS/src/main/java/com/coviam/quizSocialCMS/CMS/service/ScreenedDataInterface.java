package com.coviam.quizSocialCMS.CMS.service;

import com.coviam.quizSocialCMS.CMS.entity.ScreenedDataEntityClass;

import java.util.List;

public interface ScreenedDataInterface {
    public ScreenedDataEntityClass saveQuestion(ScreenedDataEntityClass screenedDataEntityClass);

    public List<ScreenedDataEntityClass> getScreenedQuestionsByCategory(String category);

}
