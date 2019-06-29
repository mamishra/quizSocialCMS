package com.coviam.quizMedia.Statistics.controller;

import com.coviam.quizMedia.Statistics.dto.StateDto;
import com.coviam.quizMedia.Statistics.entity.State;
import com.coviam.quizMedia.Statistics.services.StateService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping(value = "/state")
@CrossOrigin("*")
public class StateController {

    @Autowired
    StateService stateService;

    @RequestMapping(method = RequestMethod.POST, value = "/saveState")
    public ResponseEntity<?> saveState(@RequestBody State state){

        System.out.println("Save state Requested"+new Date());
        try {
            List<State> list = stateService.saveState(state);
            List<StateDto> stateDtos = new ArrayList<>();
            list.forEach((sta) -> {
                StateDto stateDto = new StateDto();
                BeanUtils.copyProperties(sta, stateDto);
                stateDtos.add(stateDto);
            });
            System.out.println("Save state Returning response"+new Date());

            return new ResponseEntity<List<StateDto>>(stateDtos, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<String>("{\"err\":\"error saving\"}", HttpStatus.OK);

        }

    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateState")
    public ResponseEntity<?> updateState(@RequestBody State state){

        try {
            List<State> list = stateService.updateState(state);
            List<StateDto> stateDtos = new ArrayList<>();
            list.forEach((sta) -> {
                StateDto stateDto = new StateDto();
                BeanUtils.copyProperties(sta, stateDto);
                stateDtos.add(stateDto);
            });

            return new ResponseEntity<List<StateDto>>(stateDtos, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<String>("{\"err\":\"error updating state\"}", HttpStatus.OK);

        }

    }


    @RequestMapping(method = RequestMethod.GET, value = "/getState")
    public ResponseEntity<?> getquestionByCategory(@RequestParam(name = "userId") String userId, @RequestParam(name = "contestId") String contestId){

        try {
            State state = stateService.fetchState(userId, contestId);
            StateDto stateDto = new StateDto();
            BeanUtils.copyProperties(state, stateDto);

            return new ResponseEntity<StateDto>(stateDto, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<String>("{\"err\":\"error getting state\"}", HttpStatus.OK);

        }
    }
}
