package edu.virginia.cs.hw3;

import java.io.*;

public class CSVStateReader extends StateReader {
    public static final int NAME_COLUMN_INDEX = 0;
    public static final int POPULATION_COLUMN_INDEX = 1;
    private final String filename;

    public CSVStateReader(String filename) {
        if (!filename.toLowerCase().endsWith(".csv")) {
            throw new IllegalArgumentException("Error: cannot open non csv file " + filename);
        }
        this.filename = filename;
    }

    @Override
    public void readStates() {
        try {
            BufferedReader bufferedReader = generateBufferedReader();
            getStatesFromReader(bufferedReader);
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private BufferedReader generateBufferedReader() throws FileNotFoundException {
        FileReader fileReader = new FileReader(filename);
        return new BufferedReader(fileReader);
    }

    private void getStatesFromReader(BufferedReader bufferedReader) throws IOException {
        for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
            try {
                addStateFromLine(line);
            } catch (IndexOutOfBoundsException | IllegalArgumentException ignored) {
            }
        }
    }

    private void addStateFromLine(String line) {
        String[] lineSplitOnCommas = line.strip().split(",");
        String stateName = lineSplitOnCommas[NAME_COLUMN_INDEX].strip();
        int statePopulation = Integer.parseInt(lineSplitOnCommas[POPULATION_COLUMN_INDEX].strip());
        State newState = new State(stateName, statePopulation);
        stateList.add(newState);
    }
}
