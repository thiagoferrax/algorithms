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
import java.util.HashSet;
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
		int companies = arrival.size();

		if (companies < 2) {
			return companies;
		}

		int max = 0;
		int nextAvailableTime = arrival.get(0);

		Map<Integer, ArrayList<Integer>> arrivalDurationMap = getArrivalDurationMap(arrival, duration);

		for (int c = 0; c < companies; c++) {
			Integer arrivalTime = arrival.get(c);
			Integer eventDuration = getMinDuration(arrivalDurationMap, arrivalTime);

			if (arrivalTime >= nextAvailableTime) {
				max++;
				nextAvailableTime = arrivalTime + eventDuration;
			} else if (isCurrentArrivalEqualsPrevius(arrival, c) && 
					thereIsTimeToAddThisEvent(arrival, nextAvailableTime, c, eventDuration)) {
				max++;
				nextAvailableTime += eventDuration;
			}
		}

		return max;
	}

	private static boolean thereIsTimeToAddThisEvent(List<Integer> arrival, int nextAvailableTime, int c,
			Integer eventDuration) {
		
		List<Integer> distinctArrivals = new ArrayList<Integer>(new HashSet<Integer>(arrival));
		int index = distinctArrivals.indexOf(arrival.get(c));
		
		if(index + 1 < distinctArrivals.size()) {
			return nextAvailableTime + eventDuration <= distinctArrivals.get(index + 1);
		}
		
		return true;
	}

	private static boolean isCurrentArrivalEqualsPrevius(List<Integer> arrival, int c) {
		Integer arrivalTime = arrival.get(c);
		return c - 1 >= 0 && arrivalTime == arrival.get(c - 1);
	}

	private static Map<Integer, ArrayList<Integer>> getArrivalDurationMap(List<Integer> arrival,
			List<Integer> duration) {

		Map<Integer, ArrayList<Integer>> durationByArrival = new HashMap<Integer, ArrayList<Integer>>();

		for (int i = 0; i < arrival.size(); i++) {
			Integer arrivalTime = arrival.get(i);
			Integer durationValue = duration.get(i);

			if (!durationByArrival.containsKey(arrivalTime)) {
				durationByArrival.put(arrivalTime, new ArrayList<Integer>(Arrays.asList(durationValue)));
			} else {
				addDurationValueInList(durationByArrival, arrivalTime, durationValue);
			}
		}

		return durationByArrival;
	}

	private static void addDurationValueInList(Map<Integer, ArrayList<Integer>> durationByArrival, Integer arrivalTime,
			Integer durationValue) {
		ArrayList<Integer> durations = new ArrayList<Integer>(durationByArrival.get(arrivalTime));
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
