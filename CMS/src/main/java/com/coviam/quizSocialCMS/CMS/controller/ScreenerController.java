package com.coviam.quizSocialCMS.CMS.controller;


import com.coviam.quizSocialCMS.CMS.entity.ScreenedDataEntityClass;
import com.coviam.quizSocialCMS.CMS.entityDto.IncommingDataDto;
import com.coviam.quizSocialCMS.CMS.service.impl.ScreenedDataService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/screener")

public class ScreenerController {

    @Autowired
    ScreenedDataService screenedDataService;

    @RequestMapping(method = RequestMethod.POST,value = "/saveScreenedQuestion")
    public ResponseEntity<?> saveScreenedQuestion(@RequestBody List<IncommingDataDto> incommingDataDto1)
    {
        for(IncommingDataDto incommingDataDto:incommingDataDto1) {
            ScreenedDataEntityClass screenedDataEntityClass = new ScreenedDataEntityClass();
            BeanUtils.copyProperties(incommingDataDto, screenedDataEntityClass);
            try {
                screenedDataService.saveQuestion(screenedDataEntityClass);
            } catch (Exception e) {
                return new ResponseEntity<>("{\"status\":\"unable to save\"}", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("{\"status\":\"saved\"}", HttpStatus.OK);

    }



}
