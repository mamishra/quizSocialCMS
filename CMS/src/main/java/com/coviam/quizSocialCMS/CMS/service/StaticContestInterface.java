package com.coviam.quizSocialCMS.CMS.service;

import com.coviam.quizSocialCMS.CMS.entity.StaticContestEntityClass;

public interface StaticContestInterface {

    public StaticContestEntityClass saveContest(StaticContestEntityClass staticContestEntityClass);
    public StaticContestEntityClass getContestById(String id);
    public void deleteContestById(String id);

}
