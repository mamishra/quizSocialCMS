package com.coviam.quizSocialCMS.CMS.service;

import com.coviam.quizSocialCMS.CMS.entity.StaticContestEntityClass;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StaticContestInterface {

    public StaticContestEntityClass saveContest(StaticContestEntityClass staticContestEntityClass);
    public StaticContestEntityClass getContestById(String id);
    public void deleteContestById(String id);
    public List<StaticContestEntityClass> getActiveContest();


}
