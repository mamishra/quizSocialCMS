package com.coviam.quizSocialCMS.CMS.service.impl;

import com.coviam.quizSocialCMS.CMS.entity.StaticContestEntityClass;
import com.coviam.quizSocialCMS.CMS.repository.StaticContestRepository;
import com.coviam.quizSocialCMS.CMS.service.StaticContestInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaticContestService implements StaticContestInterface {

    @Autowired
    StaticContestRepository staticContestRepository;

    @Override
    public StaticContestEntityClass saveContest(StaticContestEntityClass staticContestEntityClass) {
        return staticContestRepository.save(staticContestEntityClass);
    }

    @Override
    public StaticContestEntityClass getContestById(String id) {
        return staticContestRepository.findOne(id);
    }

    @Override
    public void deleteContestById(String id) {
        staticContestRepository.delete(id);
    }
}
