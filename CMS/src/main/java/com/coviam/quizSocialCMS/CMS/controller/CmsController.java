package com.coviam.quizSocialCMS.CMS.controller;

import com.coviam.quizSocialCMS.CMS.entity.StaticContestEntityClass;
import com.coviam.quizSocialCMS.CMS.entityDto.StaticContestDto;
import com.coviam.quizSocialCMS.CMS.service.impl.StaticContestService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

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
            Date endTimeOfContest=new Date(staticContestEntityClass.getEndTime().getTime()+staticContestEntityClass.getDurationOfContest().getTime());
            Timer timer=new Timer();
            ContestEndTaskScheduler scheduler=new ContestEndTaskScheduler(endTimeOfContest,staticContestEntityClass.getContestId(),timer);
            timer.schedule(scheduler,0,6000);
            return new ResponseEntity<>("{\"status\":\"saved\"}", HttpStatus.OK);

        }
        catch (Exception e)
        {
            return new ResponseEntity<>("{\"status\":\"error saving contest\"}", HttpStatus.OK);

        }

    }



    @RequestMapping(method = RequestMethod.GET,value = "/getContestById/{id}")
    public ResponseEntity<?> getContestById(@PathVariable("id") String id)
    {
        try{
            StaticContestEntityClass staticContestEntityClass=staticContestService.getContestById(id);
            if(staticContestEntityClass==null)
            {
                return new ResponseEntity<String>("{\"err\":\"contest ended\"}", HttpStatus.OK);
            }
            return new ResponseEntity<StaticContestEntityClass>(staticContestEntityClass, HttpStatus.OK);

        }catch (Exception e) {
            return new ResponseEntity<String>("{\"err\":\"contest ended\"}", HttpStatus.OK);

        }
    }

    private class ContestEndTaskScheduler extends TimerTask{

        Date endTimeOfContest;
        String contestId;
        Timer t;

        public ContestEndTaskScheduler(Date endTimeOfContest, String contestId,Timer t) {
            this.endTimeOfContest = endTimeOfContest;
            this.contestId = contestId;
            this.t=t;
        }

        @Override
        public void run() {
            Date nowTime=new Date();
            System.out.println("hey");

            if(endTimeOfContest.before(nowTime))
            {
                staticContestService.deleteContestById(contestId);
                t.cancel();
            }
        }
    }


}
