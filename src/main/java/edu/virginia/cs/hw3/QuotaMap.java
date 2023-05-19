package edu.virginia.cs.hw3;

import java.util.HashMap;
import java.util.Map;

public class QuotaMap {
    Map<State, Double> stateQuotaMap = new HashMap<>();

    public void setDecimalApportionmentForState(State state, double quota) {
        stateQuotaMap.put(state, quota);
    }

    public Apportionment getRoundedDownApportionment() {
        Apportionment apportionment = new Apportionment();
        for (State state : stateQuotaMap.keySet()) {
            int roundedDownQuota = (int) Math.floor(stateQuotaMap.get(state));
            apportionment.addRepresentativesToState(state, roundedDownQuota);
        }
        return apportionment;
    }

    public Map<State, Double> getRemainderMap() {
        Map<State, Double> remainderMap = new HashMap<>();
        for (State state : stateQuotaMap.keySet()) {
            double remainder = getRemainderForState(state);
            remainderMap.put(state, remainder);
        }
        return remainderMap;
    }

    public double getRemainderForState(State state) {
        return stateQuotaMap.get(state) - getRoundedDownQuotaForState(state);
    }

    public int getRoundedDownQuotaForState(State state) {
        return (int) Math.floor(stateQuotaMap.get(state));
    }
}
