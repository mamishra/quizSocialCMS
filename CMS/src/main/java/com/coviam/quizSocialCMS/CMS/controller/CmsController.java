package com.coviam.quizSocialCMS.CMS.controller;

import com.coviam.quizSocialCMS.CMS.entity.ScreenedDataEntityClass;
import com.coviam.quizSocialCMS.CMS.entity.StaticContestEntityClass;
import com.coviam.quizSocialCMS.CMS.entityDto.ActiveContestDto;
import com.coviam.quizSocialCMS.CMS.entityDto.RandomQuizDto;
import com.coviam.quizSocialCMS.CMS.entityDto.StaticContestDto;
import com.coviam.quizSocialCMS.CMS.repository.StaticContestRepository;
import com.coviam.quizSocialCMS.CMS.service.impl.StaticContestService;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/cms")
@CrossOrigin(origins = "*")
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
            return new ResponseEntity<>("{\"msg\":\"saved\"}", HttpStatus.OK);

        }
        catch (Exception e)
        {
            return new ResponseEntity<>("{\"err\":\"error saving contest\"}", HttpStatus.OK);

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


    @RequestMapping(method = RequestMethod.GET,value = "/getActiveContests/{page}")
    public ResponseEntity<List<ActiveContestDto>> getActiveContest(@PathVariable("page") int pageOfSet)
    {
        List<StaticContestEntityClass> staticContestEntityClasses=staticContestService.getActiveContest() ;
        List<ActiveContestDto> activeContestDtos=new ArrayList<>();
        for(StaticContestEntityClass staticContestEntityClass:staticContestEntityClasses)
        {
            ActiveContestDto activeContestDto=new ActiveContestDto();
            BeanUtils.copyProperties(staticContestEntityClass,activeContestDto);
            activeContestDtos.add(activeContestDto);
        }
        return new ResponseEntity<List<ActiveContestDto>>(activeContestDtos,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/getRandomQuestion")
    public ResponseEntity<RandomQuizDto> getRandomQuestion()
    {
        List<StaticContestEntityClass> staticContestEntityClasses=staticContestService.getActiveContest();
        Random random=new Random();
        int i=random.nextInt(staticContestEntityClasses.size()-1);
        StaticContestEntityClass staticContestEntityClass=staticContestEntityClasses.get(i);
        i=random.nextInt()%(staticContestEntityClass.getQuestionId().size());
        RandomQuizDto randomQuizDto=new RandomQuizDto();
        BeanUtils.copyProperties(staticContestEntityClass,randomQuizDto);
        randomQuizDto.setQuestionId(staticContestEntityClass.getQuestionId().get(i));
        return new ResponseEntity<RandomQuizDto>(randomQuizDto,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/getContestByCategory/{category}/{page}")
    public ResponseEntity<List<ActiveContestDto>> getContestByCategory(@PathVariable("category") String category,@PathVariable("page")int page)
    {
        Page<StaticContestEntityClass> staticContestEntityClasses=staticContestService.getContestByCategory(category,page) ;
        List<StaticContestEntityClass> list=Lists.newArrayList(staticContestEntityClasses);
        List<ActiveContestDto> finalList=new ArrayList<>();
        for(StaticContestEntityClass staticContestEntityClass:list)
        {
            ActiveContestDto activeContestDto=new ActiveContestDto();
            BeanUtils.copyProperties(staticContestEntityClass,activeContestDto);
            finalList.add(activeContestDto);
        }
        return new ResponseEntity<List<ActiveContestDto>>(finalList,HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.GET,value = "/getContestByContestName/{name}/{page}")
    public ResponseEntity<List<ActiveContestDto>> getContestByContestName(@PathVariable("name") String name,@PathVariable("page")int page)
    {
        Page<StaticContestEntityClass> staticContestEntityClasses=staticContestService.getContestByContestName(name,page) ;
        List<StaticContestEntityClass> list=Lists.newArrayList(staticContestEntityClasses);
        List<ActiveContestDto> finalList=new ArrayList<>();
        for(StaticContestEntityClass staticContestEntityClass:list)
        {
            ActiveContestDto activeContestDto=new ActiveContestDto();
            BeanUtils.copyProperties(staticContestEntityClass,activeContestDto);
            finalList.add(activeContestDto);
        }
        return new ResponseEntity<List<ActiveContestDto>>(finalList,HttpStatus.OK);
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

