package com.coviam.quizSocialCMS.CMS.service.impl;

import com.coviam.quizSocialCMS.CMS.entity.ScreenedDataEntityClass;
import com.coviam.quizSocialCMS.CMS.repository.ScreenedDatabaseRepo;
import com.coviam.quizSocialCMS.CMS.service.ScreenedDataInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreenedDataService implements ScreenedDataInterface {

    @Autowired
    ScreenedDatabaseRepo screenedDatabaseRepo;

    @Override
    public ScreenedDataEntityClass saveQuestion(ScreenedDataEntityClass screenedDataEntityClass) {
        return screenedDatabaseRepo.save(screenedDataEntityClass);
    }

    @Override
    public List<ScreenedDataEntityClass> getScreenedQuestionsByCategory(String category) {
        return screenedDatabaseRepo.getScreenedQuestionsByCategory(category);
    }
}
