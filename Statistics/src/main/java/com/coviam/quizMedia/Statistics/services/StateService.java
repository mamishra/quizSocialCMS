package com.coviam.quizMedia.Statistics.services;

import com.coviam.quizMedia.Statistics.entity.State;

import java.util.List;

public interface StateService {

    List<State> saveState(State state);
    State fetchState(String userId, String contestId);
    List<State> updateState(State state);
}
