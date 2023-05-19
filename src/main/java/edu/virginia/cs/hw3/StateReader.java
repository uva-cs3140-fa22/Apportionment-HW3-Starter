package edu.virginia.cs.hw3;

import java.util.*;

public abstract class StateReader {
    protected List<State> stateList;

    public List<State> getStateList() {
        if (stateList == null) {
            stateList = new ArrayList<>();
            readStates();
        }
        return stateList;
    }

    public abstract void readStates();

    protected void addState(State state) {
        stateList.add(state);
    }
}
