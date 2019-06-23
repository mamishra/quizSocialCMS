package com.coviam.quizSocialCMS.CMS.repository;

import com.coviam.quizSocialCMS.CMS.entity.StaticContestEntityClass;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaticContestRepository extends MongoRepository<StaticContestEntityClass,String> {
}
