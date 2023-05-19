package edu.virginia.cs.hw3;

import java.util.*;

public class HamiltonMethod extends ApportionmentMethod {

    private List<State> stateList;
    private int targetRepresentatives;
    private double divisor;
    private QuotaMap quotaMap;
    private Apportionment apportionment;

    @Override
    public Apportionment getApportionment(List<State> stateList, int representatives) {
        initializeFields(stateList, representatives);
        divisor = getDivisor();
        quotaMap = getDecimalApportionment();
        return getIntegerApportionment();
    }

    private Apportionment getIntegerApportionment() {
        apportionment = getFirstPassApportionment();
        executeSecondPassApportionment();
        return apportionment;
    }

    private void initializeFields(List<State> stateList, int representatives) {
        this.stateList = stateList;
        targetRepresentatives = representatives;
    }

    private double getDivisor() {
        int totalPopulation = getTotalPopulation();
        return (double) totalPopulation / targetRepresentatives;
    }

    private QuotaMap getDecimalApportionment() {
        QuotaMap quotaMap = new QuotaMap();
        for (State state : stateList) {
            double decimalRepresentatives = state.getPopulation() / divisor;
            quotaMap.setDecimalApportionmentForState(state, decimalRepresentatives);
        }
        return quotaMap;
    }

    private Apportionment getFirstPassApportionment() {
        return quotaMap.getRoundedDownApportionment();
    }

    private void executeSecondPassApportionment() {
        int repsLeftToAllocate = getRepsLeftToAllocate();
        Map<State, Double> remainderMap = quotaMap.getRemainderMap();
        remainderMap.entrySet().stream()
                .sorted((e1, e2) -> (Double.compare(e2.getValue(), e1.getValue())))
                .limit(repsLeftToAllocate)
                .map(Map.Entry::getKey)
                .forEach(state -> apportionment.addRepresentativesToState(state, 1));
    }

    private int getTotalPopulation() {
        int totalPopulation = 0;
        for (State state : stateList) {
            totalPopulation += state.getPopulation();
        }
        return totalPopulation;
    }

    private int getRepsLeftToAllocate() {
        int allocatedRepresentatives = apportionment.getAllocatedRepresentatives();
        return targetRepresentatives - allocatedRepresentatives;
    }
}
