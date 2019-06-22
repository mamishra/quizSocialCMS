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

@RestController
public class MainController {

    @Autowired
    ScreenedDataService screenedDataService;

    @RequestMapping(method = RequestMethod.POST,value = "/saveScreenedQuestion")
    public ResponseEntity<?> saveScreenedQuestion(@RequestBody IncommingDataDto incommingDataDto)
    {
        ScreenedDataEntityClass screenedDataEntityClass=new ScreenedDataEntityClass();
        BeanUtils.copyProperties(incommingDataDto,screenedDataEntityClass);
        try{
            screenedDataService.saveQuestion(screenedDataEntityClass);
            return new ResponseEntity<>("{\"status\":\"saved\"}", HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>("{\"status\":\"unable to save\"}",HttpStatus.OK);
        }

    }


}
