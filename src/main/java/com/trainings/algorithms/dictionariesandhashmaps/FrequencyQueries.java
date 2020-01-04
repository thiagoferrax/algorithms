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
		List<Integer> frequencies = new ArrayList<Integer>();

		Map<Integer, Integer> map = new HashMap();

		for (List<Integer> query : queries) {
			Integer operation = query.get(0);
			Integer value = query.get(1);

			if (operation == 1) {
				if (!map.containsKey(value)) {
					map.put(value, 1);
				} else {
					int quantity = map.get(value) + 1;
					map.put(value, quantity);
				}
			} else if (operation == 2) {
				if (map.containsKey(value)) {
					map.put(value, Math.max(0, map.get(value) - 1));
				}
			} else if (operation == 3) {
				Integer matched = matched(map, value);
				frequencies.add(matched);
			}
		}

		return frequencies;
	}

	private static Integer matched(Map<Integer, Integer> map, Integer value) {
		return map.values().contains(value) ? 1 : 0;
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