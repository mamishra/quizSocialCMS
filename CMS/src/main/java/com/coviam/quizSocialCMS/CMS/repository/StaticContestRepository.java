package com.coviam.quizSocialCMS.CMS.repository;

import com.coviam.quizSocialCMS.CMS.entity.StaticContestEntityClass;
import com.coviam.quizSocialCMS.CMS.entityDto.ActiveContestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaticContestRepository extends MongoRepository<StaticContestEntityClass,String> {

    @Query("{'category':{$regex:?0}}")
    public List<StaticContestEntityClass> findByCategory(String name);

    @Query("{'contestName':{$regex:?0}}")
    public List<StaticContestEntityClass> findByContestName(String name);



}
