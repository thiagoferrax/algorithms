package com.trainings.algorithms.dictionariesandhashmaps;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FrequencyQueries {

	// Complete the freqQuery function below.
	static List<Integer> freqQuery(List<List<Integer>> queries) {
		List<Integer> matches = new ArrayList<Integer>();

		Map<Integer, Integer> values = new HashMap<Integer, Integer>();
		Map<Integer, Map<Integer, Integer>> frequencies = new HashMap<Integer, Map<Integer, Integer>>();

		for (List<Integer> query : queries) {
			Integer operation = query.get(0), value = query.get(1);
			Integer frequency = null, newFrequency = null;

			if (operation == 1) {
				newFrequency = 1;

				if (!values.containsKey(value)) {
					values.put(value, newFrequency);
				} else {
					frequency = values.get(value);
					newFrequency = values.get(value) + 1;
					values.put(value, newFrequency);
				}

				updateFrequencies(frequencies, value, frequency, newFrequency);

			} else if (operation == 2) {
				if (values.containsKey(value)) {
					frequency = values.get(value);
					newFrequency = Math.max(0, values.get(value) - 1);
					values.put(value, newFrequency);

					updateFrequencies(frequencies, value, frequency, newFrequency);
				}
			} else if (operation == 3) {
				Integer matched = frequencies.containsKey(value) ? 1 : 0;
				matches.add(matched);
			}
		}

		return matches;
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

		Map<Integer, Integer> valuesMap = new HashMap<Integer, Integer>();
		if (frequencies.containsKey(newFrequency)) {
			valuesMap = frequencies.get(newFrequency);
		}
		valuesMap.put(value, newFrequency);
		frequencies.put(newFrequency, valuesMap);

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int q = Integer.parseInt(bufferedReader.readLine().trim());

		List<List<Integer>> queries = new ArrayList<>();

		IntStream.range(0, q).forEach(i -> {
			try {
				queries.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
						.map(Integer::parseInt).collect(toList()));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		List<Integer> ans = freqQuery(queries);

		bufferedWriter.write(ans.stream().map(Object::toString).collect(joining("\n")) + "\n");

		bufferedReader.close();
		bufferedWriter.close();
	}
}