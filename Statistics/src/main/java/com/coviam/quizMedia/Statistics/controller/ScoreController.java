package com.coviam.quizMedia.Statistics.controller;

import com.coviam.quizMedia.Statistics.dto.ScoreDto;
import com.coviam.quizMedia.Statistics.entity.Score;
import com.coviam.quizMedia.Statistics.entity.State;
import com.coviam.quizMedia.Statistics.services.ScoreService;
import com.coviam.quizMedia.Statistics.services.impl.ScoreServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/score")
@CrossOrigin("*")
public class ScoreController {

    @Autowired
    ScoreService scoreService;
    @Autowired
    ScoreServiceImpl scoreServiceImpl;

    @RequestMapping(method = RequestMethod.POST, value = "/saveScore")
    public ResponseEntity<?> saveScore(@RequestBody State state) {

        try{
            List<Score> list = scoreService.saveScore(state);
            List<ScoreDto> scoreDtos = new ArrayList<>();
            list.forEach((sta) -> {
                ScoreDto scoreDto = new ScoreDto();
                BeanUtils.copyProperties(sta, scoreDto);
                scoreDtos.add(scoreDto);
                scoreServiceImpl.calculateGlobalLeaderBoard("1", "Global");
                scoreServiceImpl.calculateWeeklyLeaderBoard("2", "Weekly");
                scoreServiceImpl.calculateDailyLeaderBoard("3", "Daily");
                //scoreServiceImpl.calculateLeaderBoardPerContest(state.getContestId(),state.getContestName());
            });

            return new ResponseEntity<List<ScoreDto>>(scoreDtos, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<String>("{\"err\":\"error saving\"}", HttpStatus.OK);

        }

    }

    @RequestMapping(method = RequestMethod.GET, value = "/getScore")
    public ResponseEntity<?> getScore(@RequestBody State state){

        try {
            List<Score> scoreList = scoreService.fetchScore(state);
            ScoreDto scoreDto = new ScoreDto();
            scoreList.forEach((score) -> {
                if (score.getUserId().equals(state.getUserId())) {
                    BeanUtils.copyProperties(score, scoreDto);
                }
            });

            return new ResponseEntity<ScoreDto>(scoreDto, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<String>("{\"err\":\"error getting score\"}", HttpStatus.OK);

        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getScore/{contestId}")
    public ResponseEntity<?> getScoreByContestId(@PathVariable("contestId") String contestId){

        try {
            List<Score> scoreList = scoreService.scoreByContestId(contestId);
            List<ScoreDto> scoreDtoList = new ArrayList<>();
            scoreList.forEach((score) -> {
                ScoreDto scoreDto = new ScoreDto();
                BeanUtils.copyProperties(score, scoreDto);
                scoreDtoList.add(scoreDto);
            });
            return new ResponseEntity<List<ScoreDto>>(scoreDtoList, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<String>("{\"err\":\"error getting score\"}", HttpStatus.OK);

        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getScoreByUserIdContestId")
    public ResponseEntity<?> getScoreByContestIdUserId(@RequestParam(name = "userId") String userId, @RequestParam(name = "contestId") String contestId){

        try {
            List<Score> scoreList = scoreService.scoreByContestId(contestId);
            ScoreDto scoreDto = new ScoreDto();
            scoreList.forEach((score) -> {
                if (score.getUserId().equals(userId)) {
                    BeanUtils.copyProperties(score, scoreDto);
                }
            });
            return new ResponseEntity<ScoreDto>(scoreDto, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<String>("{\"err\":\"error getting score\"}", HttpStatus.OK);

        }
    }

}
