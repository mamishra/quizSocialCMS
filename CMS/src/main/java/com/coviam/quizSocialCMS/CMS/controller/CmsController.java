package com.coviam.quizSocialCMS.CMS.controller;

import com.coviam.quizSocialCMS.CMS.entity.ScreenedDataEntityClass;
import com.coviam.quizSocialCMS.CMS.entity.StaticContestEntityClass;
import com.coviam.quizSocialCMS.CMS.entityDto.ActiveContestDto;
import com.coviam.quizSocialCMS.CMS.entityDto.RandomQuizDto;
import com.coviam.quizSocialCMS.CMS.entityDto.StaticContestDto;
import com.coviam.quizSocialCMS.CMS.service.StaticContestInterface;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.*;

@RestController
@RequestMapping(value = "/cms")
@CrossOrigin(origins = "*")
public class CmsController {

    @Autowired
    StaticContestInterface staticContestInterface;

    @PostConstruct
    public void initiator(){
        List<StaticContestEntityClass> staticContestEntityClasses= staticContestInterface.findAll();
        try {


            if (staticContestEntityClasses != null) {
                for (StaticContestEntityClass staticContestEntityClass : staticContestEntityClasses) {
                    Date endTimeOfContest = new Date(staticContestEntityClass.getEndTime().getTime() + staticContestEntityClass.getDurationOfContest().getTime());
                    Timer timer = new Timer();
                    ContestEndTaskScheduler scheduler = new ContestEndTaskScheduler(endTimeOfContest, staticContestEntityClass.getContestId(), timer);
                    timer.schedule(scheduler, 0, 6000);
                }
            }
        }
        catch (Exception e)
        {

        }

    }

    @RequestMapping(method = RequestMethod.POST,value = "/saveContest")
    public ResponseEntity<?> saveContest(@RequestBody StaticContestDto staticContestDto)
    {
        StaticContestEntityClass staticContestEntityClass=new StaticContestEntityClass();
        BeanUtils.copyProperties(staticContestDto,staticContestEntityClass);
        try {
            staticContestInterface.saveContest(staticContestEntityClass);
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
            StaticContestEntityClass staticContestEntityClass= staticContestInterface.getContestById(id);
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
        List<StaticContestEntityClass> staticContestEntityClasses= staticContestInterface.getActiveContest() ;
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
        RandomQuizDto randomQuizDto=new RandomQuizDto();
        try{
        List<StaticContestEntityClass> staticContestEntityClasses= staticContestInterface.getActiveContest();
        if(staticContestEntityClasses.size()==0){
            return new ResponseEntity<>(randomQuizDto,HttpStatus.OK);
        }
        Random random=new Random();
        int maxLoop=10,i;
        StaticContestEntityClass staticContestEntityClass=new StaticContestEntityClass();
        while(maxLoop-->0){
            i=random.nextInt(staticContestEntityClasses.size()-1);
            staticContestEntityClass=staticContestEntityClasses.get(i);
            if(staticContestEntityClass.getStartTime().before(new Date()))
            {
                break;
            }
        }
        i=random.nextInt()%(staticContestEntityClass.getQuestionId().size());
        BeanUtils.copyProperties(staticContestEntityClass,randomQuizDto);
        randomQuizDto.setQuestionId(staticContestEntityClass.getQuestionId().get(i));
        return new ResponseEntity<RandomQuizDto>(randomQuizDto,HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<RandomQuizDto>(randomQuizDto,HttpStatus.OK);

        }

    }

    @RequestMapping(method = RequestMethod.GET,value = "/getContestByCategory/{category}/{page}")
    public ResponseEntity<List<ActiveContestDto>> getContestByCategory(@PathVariable("category") String category,@PathVariable("page")int page)
    {
        Page<StaticContestEntityClass> staticContestEntityClasses= staticContestInterface.getContestByCategory(category,page) ;
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
        Page<StaticContestEntityClass> staticContestEntityClasses= staticContestInterface.getContestByContestName(name,page) ;
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

    @RequestMapping(method = RequestMethod.GET,value = "/getContestQuestions/{contestId}")
    public ResponseEntity<List<ScreenedDataEntityClass>> getContestQuestion(@PathVariable("contestId")String contestId)
    {
        List<ScreenedDataEntityClass> list=staticContestInterface.getContestById(contestId).getQuestionId();
        return new ResponseEntity<List<ScreenedDataEntityClass>>(list,HttpStatus.OK);
    }



    private class ContestEndTaskScheduler extends TimerTask{

        Date endTimeOfContest;
        String contestId;
        Timer t;
        boolean isActive;
        Date startTimeOfContest;

        public ContestEndTaskScheduler(Date endTimeOfContest, String contestId,Timer t) {
            this.endTimeOfContest = endTimeOfContest;
            this.contestId = contestId;
            this.t=t;
            startTimeOfContest=staticContestInterface.getContestById(contestId).getStartTime();
            Date nowTime=new Date();
            if(startTimeOfContest.before(nowTime)){
                StaticContestEntityClass staticContestEntityClass = staticContestInterface.getContestById(contestId);
                staticContestEntityClass.setActive(true);
                isActive=true;
                staticContestInterface.saveContest(staticContestEntityClass);

            }
            else{
                StaticContestEntityClass staticContestEntityClass = staticContestInterface.getContestById(contestId);
                staticContestEntityClass.setActive(false);
                isActive = false;
                staticContestInterface.saveContest(staticContestEntityClass);
            }
        }

        @Override
        public void run() {
            Date nowTime=new Date();
            //System.out.println("looping for "+contestId);
           // t.cancel();
            if(isActive==true) {
                if (endTimeOfContest.before(nowTime)) {
                    StaticContestEntityClass staticContestEntityClass = staticContestInterface.getContestById(contestId);
                    staticContestEntityClass.setActive(false);
                    isActive = false;
                    staticContestInterface.saveContest(staticContestEntityClass);
                    t.cancel();
                }
            }
            else{
                if(startTimeOfContest.before(nowTime)){
                    StaticContestEntityClass staticContestEntityClass = staticContestInterface.getContestById(contestId);
                    staticContestEntityClass.setActive(true);
                    isActive = true;
                    staticContestInterface.saveContest(staticContestEntityClass);
                }
            }
        }
    }


}

