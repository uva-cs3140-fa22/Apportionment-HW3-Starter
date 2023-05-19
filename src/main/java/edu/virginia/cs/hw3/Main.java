package edu.virginia.cs.hw3;

import java.util.List;

public class Main {
    private static Configuration config;

    public static void main(String[] args) {
        config = loadConfigurationFromArguments(args);
        run();
    }

    private static void run() {
        List<State> stateList = getStateList();
        int representatives = config.getRepresentatives();
        Apportionment apportionment = getApportionment(stateList, representatives);
        displayFormattedString(apportionment);
    }

    private static List<State> getStateList() {
        StateReader reader = config.getStateReader();
        return reader.getStateList();
    }

    private static Apportionment getApportionment(List<State> stateList, int representatives) {
        ApportionmentMethod method = config.getApportionmentMethod();
        return method.getApportionment(stateList, representatives);
    }

    private static void displayFormattedString(Apportionment apportionment) {
        ApportionmentFormat format = config.getFormat();
        System.out.println(format.getFormattedString(apportionment));
    }

    private static Configuration loadConfigurationFromArguments(String[] args) {
        ArgumentsHandler argumentsHandler = new ArgumentsHandler(args);
        return argumentsHandler.getConfiguration();
    }
}