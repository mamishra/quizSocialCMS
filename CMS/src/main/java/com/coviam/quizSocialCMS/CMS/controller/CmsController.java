package com.coviam.quizSocialCMS.CMS.controller;

import com.coviam.quizSocialCMS.CMS.entity.StaticContestEntityClass;
import com.coviam.quizSocialCMS.CMS.entityDto.StaticContestDto;
import com.coviam.quizSocialCMS.CMS.service.impl.StaticContestService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cms")
public class CmsController {

    @Autowired
    StaticContestService staticContestService;

    @RequestMapping(method = RequestMethod.POST,value = "/saveContest")
    public ResponseEntity<?> saveContest(@RequestBody StaticContestDto staticContestDto)
    {
        StaticContestEntityClass staticContestEntityClass=new StaticContestEntityClass();
        BeanUtils.copyProperties(staticContestDto,staticContestEntityClass);
        try {
            staticContestService.saveContest(staticContestEntityClass);
            return new ResponseEntity<>("{\"status\":\"saved\"}", HttpStatus.OK);

        }
        catch (Exception e)
        {
            return new ResponseEntity<>("{\"status\":\"saved\"}", HttpStatus.OK);

        }

    }




}
