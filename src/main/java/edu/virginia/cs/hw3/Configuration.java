package edu.virginia.cs.hw3;

public class Configuration {
    private ApportionmentMethod apportionmentStrategy;
    private StateReader stateReader;
    private int representatives;
    private ApportionmentFormat apportionmentFormat;
    public ApportionmentMethod getApportionmentMethod() {
        return apportionmentStrategy;
    }

    public void setApportionmentStrategy(ApportionmentMethod apportionmentStrategy) {
        this.apportionmentStrategy = apportionmentStrategy;
    }

    public StateReader getStateReader() {
        return stateReader;
    }

    public void setStateReader(StateReader stateReader) {
        this.stateReader = stateReader;
    }

    public int getRepresentatives() {
        return representatives;
    }

    public void setRepresentatives(int representatives) {
        this.representatives = representatives;
    }

    public ApportionmentFormat getFormat() {
        return apportionmentFormat;
    }

    public void setApportionmentFormat(ApportionmentFormat apportionmentFormat) {
        this.apportionmentFormat = apportionmentFormat;
    }
}
