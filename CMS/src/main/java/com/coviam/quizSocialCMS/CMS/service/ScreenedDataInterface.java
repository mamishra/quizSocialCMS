package com.coviam.quizSocialCMS.CMS.service;

import com.coviam.quizSocialCMS.CMS.entity.ScreenedDataEntityClass;
import com.coviam.quizSocialCMS.CMS.entityDto.IncommingDataDto;

public interface ScreenedDataInterface {
    public ScreenedDataEntityClass saveQuestion(ScreenedDataEntityClass screenedDataEntityClass);
}
