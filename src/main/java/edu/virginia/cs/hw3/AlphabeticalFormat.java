package edu.virginia.cs.hw3;

import java.util.Comparator;
import java.util.stream.Collectors;

public class AlphabeticalFormat extends ApportionmentFormat{
    private Apportionment apportionment;

    @Override
    public String getFormattedString(Apportionment apportionment) {
        this.apportionment = apportionment;
        return getAlphabeticalApportionmentString();
    }

    private String getAlphabeticalApportionmentString() {
        return apportionment.getStateSet().stream()
                .sorted(Comparator.comparing(State::getName))
                .map(this::getApportionmentStringForState)
                .collect(Collectors.joining("\n"));
    }

    private String getApportionmentStringForState(State state) {
        String stateName = state.getName();
        int apportionedRepresentatives = apportionment.getRepresentativesForState(state);
        return stateName + " - " + apportionedRepresentatives;
    }
}
