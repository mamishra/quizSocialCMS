package com.coviam.quizSocialCMS.CMS.repository;

import com.coviam.quizSocialCMS.CMS.entity.CategoryEntityClass;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryCollectionRepository extends MongoRepository<CategoryEntityClass,String> {


}
