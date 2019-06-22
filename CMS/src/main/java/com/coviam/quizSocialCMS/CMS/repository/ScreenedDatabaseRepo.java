package com.coviam.quizSocialCMS.CMS.repository;

import com.coviam.quizSocialCMS.CMS.entity.ScreenedDataEntityClass;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreenedDatabaseRepo extends MongoRepository<ScreenedDataEntityClass,String> {
}
