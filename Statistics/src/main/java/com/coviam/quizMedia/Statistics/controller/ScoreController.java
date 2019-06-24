package com.coviam.quizMedia.Statistics.controller;

import com.coviam.quizMedia.Statistics.dto.ScoreDto;
import com.coviam.quizMedia.Statistics.entity.Score;
import com.coviam.quizMedia.Statistics.entity.State;
import com.coviam.quizMedia.Statistics.services.ScoreService;
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

    @RequestMapping(method = RequestMethod.POST, value = "/saveScore")
    public ResponseEntity<?> saveScore(@RequestBody State state){

        List<Score> list = scoreService.saveScore(state);
        List<ScoreDto> scoreDtos = new ArrayList<>();
        list.forEach((sta)->{
            ScoreDto scoreDto = new ScoreDto();
            BeanUtils.copyProperties(sta,scoreDto);
            scoreDtos.add(scoreDto);
        });

        return new ResponseEntity<List<ScoreDto>>( scoreDtos, HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.GET, value = "/getScore")
    public ResponseEntity<?> getScore(@RequestBody State state){

        List<Score> scoreList = scoreService.fetchScore(state);
        ScoreDto scoreDto = new ScoreDto();
        scoreList.forEach((score)->{
            if (score.getUserId().equals(state.getUserId())){
                BeanUtils.copyProperties(score,scoreDto);
            }
        });

        return new ResponseEntity<ScoreDto>(scoreDto,HttpStatus.OK);
    }

}
