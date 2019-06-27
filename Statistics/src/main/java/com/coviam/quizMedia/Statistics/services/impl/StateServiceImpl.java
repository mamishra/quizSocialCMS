package com.coviam.quizMedia.Statistics.services.impl;

import com.coviam.quizMedia.Statistics.entity.State;
import com.coviam.quizMedia.Statistics.repository.StateRepository;
import com.coviam.quizMedia.Statistics.services.StateService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StateServiceImpl implements StateService {

    @Autowired
    StateRepository stateRepository;

    @Override
    public List<State> saveState(State state) {
        List<State> list = new ArrayList<>();
        list.add(state);
        return stateRepository.save(list);
    }

    @Override
    public List<State> updateState(State state) {

        String contestId = state.getContestId();
        List<State> stateList = stateRepository.findByContestId(contestId);
        State state1 = new State();
        for (State st : stateList){
            if (st.getUserId().equals(state.getUserId())){
                BeanUtils.copyProperties(st,state1);
            }
        }
        List<State> list = new ArrayList<>();
        list.add(state);
        try{
            stateRepository.delete(state1.getStateId());
        }
        catch (Exception e)
        {

        }
        return stateRepository.save(list);

    }

    @Override
    public State fetchState(String userId, String contestId) {

        List<State> stateList = stateRepository.findByContestId(contestId);
        State stateObj = new State();
        stateList.forEach((state)->{
            if (state.getUserId().equals(userId)){
                BeanUtils.copyProperties(state, stateObj);
            }
        });
        return stateObj;


    }


}
