package com.coviam.quizSocialCMS.CMS.controller;


import com.coviam.quizSocialCMS.CMS.entity.ScreenedDataEntityClass;
import com.coviam.quizSocialCMS.CMS.entityDto.ScreenedQuestionDto;
import com.coviam.quizSocialCMS.CMS.service.impl.ScreenedDataService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/screener")
@CrossOrigin(origins = "*")

public class ScreenerController {

    @Autowired
    ScreenedDataService screenedDataService;

    @RequestMapping(method = RequestMethod.POST,value = "/saveScreenedQuestion")
    public ResponseEntity<?> saveScreenedQuestion(@RequestBody List<ScreenedQuestionDto> screenedQuestionDto1)
    {
        for(ScreenedQuestionDto screenedQuestionDto : screenedQuestionDto1) {
            ScreenedDataEntityClass screenedDataEntityClass = new ScreenedDataEntityClass();
            BeanUtils.copyProperties(screenedQuestionDto, screenedDataEntityClass);
            try {
                screenedDataService.saveQuestion(screenedDataEntityClass);
            } catch (Exception e) {
                return new ResponseEntity<>("{\"err\":\"unable to save\"}", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("{\"msg\":\"saved\"}", HttpStatus.OK);

    }


    @RequestMapping(method = RequestMethod.GET,value = "/getScreenedQuestionsByCategory/{category}")
    public ResponseEntity<?> getScreenedQuestion(@PathVariable("category") String category)
    {
        return new ResponseEntity<>(screenedDataService.getScreenedQuestionsByCategory(category),HttpStatus.OK);
    }



}
