package com.trainings.algorithms.dictionariesandhashmaps;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * You are given an array and you need to find number of triplets of indices (i,
 * j, k) such that the elements at those indices are in geometric progression
 * for a given common ratio r and i < j < k.
 * https://www.hackerrank.com/challenges/count-triplets-1
 */
public class CountTriplets {
	// Complete the countTriplets function below.
	static long countTripletsFirtsSolution(List<Long> arr, long r) {

		Map<Long, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < arr.size(); i++) {
			Long key = arr.get(i);
			if (!map.containsKey(key)) {
				map.put(key, Arrays.asList(i));
			} else {
				List<Integer> indexes = new ArrayList<>(map.get(key));
				indexes.add(i);
				map.put(key, indexes);
			}
		}

		int triplets = 0;
		for (int i = 0; i < arr.size(); i++) {
			Long t1 = arr.get(i);
			Long t2 = t1 * r;
			Long t3 = t2 * r;

			if (map.containsKey(t2) && map.containsKey(t3)) {
				for (Integer j : map.get(t2)) {
					if (j > i) {
						for (Integer k : map.get(t3)) {
							if (k > j) {
								triplets++;
							}
						}
					}
				}
			}
		}

		return triplets;
	}

	// Complete the countTriplets function below.
	static long countTriplets(List<Long> arr, long r) {
		long triplets = 0;

		Map<Long, Long> combinations = new HashMap<>();
		Map<Long, Long> possibilities = new HashMap<>();

		for (Long element : arr) {
			if (combinations.containsKey(element)) {
				triplets += combinations.get(element);
			}

			Long nextElement = element * r;

			if (possibilities.containsKey(element)) {
				Long value = possibilities.get(element);
				if (!combinations.containsKey(nextElement)) {
					combinations.put(nextElement, value);
				} else {
					combinations.put(nextElement, combinations.get(nextElement) + value);
				}
			}

			if (!possibilities.containsKey(nextElement)) {
				possibilities.put(nextElement, 1L);
			} else {
				possibilities.put(nextElement, possibilities.get(nextElement) + 1);
			}
		}

		return triplets;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		long r = Long.parseLong(nr[1]);

		List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Long::parseLong)
				.collect(toList());

		long ans = countTriplets(arr, r);

		bufferedWriter.write(String.valueOf(ans));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
