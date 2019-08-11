package com.trainings.algorithms.technicaltest;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

class ResultMaxEvents {

	/*
	 * Complete the 'maxEvents' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER_ARRAY arrival 2. INTEGER_ARRAY duration
	 */

	public static int maxEvents(List<Integer> arrival, List<Integer> duration) {
		if (arrival.size() < 2) {
			return arrival.size();
		}

		int max = 0;
		int nextAvailableTime = arrival.get(0);

		Map<Integer, ArrayList<Integer>> arrivalDurationMap = getDurationByArrivalMap(arrival, duration);
		for (int i = 0; i < arrival.size(); i++) {
			Integer arrivalTime = arrival.get(i);
			if (arrivalTime >= nextAvailableTime) {
				max++;
				nextAvailableTime += getMinDuration(arrivalDurationMap, arrivalTime);
			}
		}

		return max;
	}

	private static Map<Integer, ArrayList<Integer>> getDurationByArrivalMap(List<Integer> arrival,
			List<Integer> duration) {
		Map<Integer, ArrayList<Integer>> durationByArrival = new HashMap<Integer, ArrayList<Integer>>();
		for (int i = 0; i < arrival.size(); i++) {
			Integer arrivalTime = arrival.get(i);
			Integer durationValue = duration.get(i);

			if (!durationByArrival.containsKey(arrivalTime)) {
				durationByArrival.put(arrivalTime, new ArrayList<Integer>(Arrays.asList(durationValue)));
			} else {
				ArrayList<Integer> durationList = durationByArrival.get(arrivalTime);
				addDurationValueInList(durationByArrival, arrivalTime, durationValue, durationList);
			}
		}
		return durationByArrival;
	}

	private static void addDurationValueInList(Map<Integer, ArrayList<Integer>> durationByArrival, Integer arrivalTime,
			Integer durationValue, List<Integer> durationList) {
		ArrayList<Integer> durations = new ArrayList<Integer>(durationList);
		durations.add(durationValue);
		durationByArrival.put(arrivalTime, durations);
	}

	private static int getMinDuration(Map<Integer, ArrayList<Integer>> durationByArrival, Integer arrival) {
		ArrayList<Integer> list = durationByArrival.get(arrival);

		if (list.size() > 1) {
			Collections.sort(list);
		}

		return list.remove(0);
	}

}

/**
 * Calculate the maximum number of promotional events a hotel could do according
 * to the companies arrival times and events durations.
 * https://www.hackerrank.com/
 */
public class MaxEvents {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int arrivalCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> arrival = IntStream.range(0, arrivalCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(toList());

		int durationCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> duration = IntStream.range(0, durationCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(toList());

		int result = ResultMaxEvents.maxEvents(arrival, duration);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
