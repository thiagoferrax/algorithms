package com.trainings.algorithms.dictionariesandhashmaps;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.joining;

public class FrequencyQueries {

    private static final int VALUE = 1;
    private static final int OPERATION = 0;
    private static final int SEARCH = 3;
    private static final int REMOVE = 2;
    private static final int ADD = 1;

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<int[]> queries) {
        List<Integer> matches = new ArrayList<Integer>();

        Map<Integer, Integer> values = new HashMap<Integer, Integer>();
        Map<Integer, Map<Integer, Integer>> frequencies = new HashMap<Integer, Map<Integer, Integer>>();

        for (int[] query : queries) {
            Integer operation = query[OPERATION], value = query[VALUE];
            if (operation == ADD) {
                add(values, frequencies, value);
            } else if (operation == REMOVE) {
                remove(values, frequencies, value);
            } else if (operation == SEARCH) {
                matches.add(frequencies.get(value) != null ? 1 : 0);
            }
        }

        return matches;
    }

    private static void remove(Map<Integer, Integer> values, Map<Integer, Map<Integer, Integer>> frequencies,
                               Integer value) {

        Integer frequency = values.get(value);
        if (frequency != null) {
            Integer newFrequency = Math.max(0, frequency - 1);

            values.put(value, newFrequency);

            updateFrequencies(frequencies, value, frequency, newFrequency);
        }
    }

    private static void add(Map<Integer, Integer> values, Map<Integer, Map<Integer, Integer>> frequencies,
                            Integer value) {

        Integer frequency = values.get(value);
        Integer newFrequency = frequency == null ? 1 : frequency + 1;

        values.put(value, newFrequency);

        updateFrequencies(frequencies, value, frequency, newFrequency);
    }

    private static void updateFrequencies(Map<Integer, Map<Integer, Integer>> frequencies, Integer value,
                                          Integer frequency, Integer newFrequency) {
        if (frequency != null) {
            Map<Integer, Integer> valuesMap = frequencies.get(frequency);
            if (valuesMap.size() <= 1) {
                frequencies.remove(frequency);
            } else {
                valuesMap.remove(value);
                frequencies.put(frequency, valuesMap);
            }
        }

        Map<Integer, Integer> valuesMap = frequencies.get(newFrequency);
        if (valuesMap == null) {
            valuesMap = new HashMap<Integer, Integer>();
        }
        valuesMap.put(value, newFrequency);
        frequencies.put(newFrequency, valuesMap);

    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int q = Integer.parseInt(bufferedReader.readLine().trim());
            List<int[]> queries = new ArrayList<>(q);
            Pattern p = Pattern.compile("^(\\d+)\\s+(\\d+)\\s*$");
            for (int i = 0; i < q; i++) {
                int[] query = new int[2];
                Matcher m = p.matcher(bufferedReader.readLine());
                if (m.matches()) {
                    query[0] = Integer.parseInt(m.group(1));
                    query[1] = Integer.parseInt(m.group(2));
                    queries.add(query);
                }
            }
            List<Integer> ans = freqQuery(queries);
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {
                bufferedWriter.write(ans.stream().map(Object::toString).collect(joining("\n")) + "\n");
            }
        }
    }
}