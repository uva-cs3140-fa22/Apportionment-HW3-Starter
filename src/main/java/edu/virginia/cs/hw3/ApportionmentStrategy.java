package edu.virginia.cs.hw3;

import java.util.*;

public abstract class ApportionmentStrategy {
    public abstract Apportionment getApportionment(List<State> stateList, int representatives);
}
