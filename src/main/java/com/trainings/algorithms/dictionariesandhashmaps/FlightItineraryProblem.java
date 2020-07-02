package com.trainings.algorithms.dictionariesandhashmaps;

import java.util.HashMap;
import java.util.Map;

import com.trainings.algorithms.arrays.NewYearChaos;

/**
 * Question #1: (Facebook) Given an unordered list of flights taken by someone,
 * each represented as (origin, destination) pairs, and a starting airport,
 * compute the person's itinerary. If no such itinerary exists, return null. If
 * there are multiple possible itineraries, return the lexicographically
 * smallest one. All flights must be used in the itinerary.
 * 
 * For example, given the list of flights [('SFO', 'HKO'), ('YYZ', 'SFO'),
 * ('YUL', 'YYZ'), ('HKO', 'ORD')] and starting airport 'YUL', you should return
 * the list ['YUL', 'YYZ', 'SFO', 'HKO', 'ORD'].
 * 
 * Given the list of flights [('SFO', 'COM'), ('COM', 'YYZ')] and starting
 * airport 'COM', you should return null.
 * 
 * Given the list of flights [('A', 'B'), ('A', 'C'), ('B', 'C'), ('C', 'A')]
 * and starting airport 'A', you should return the list ['A', 'B', 'C', 'A',
 * 'C'] even though ['A', 'C', 'A', 'B', 'C'] is also a valid itinerary.
 * However, the first one is lexicographically smaller.
 * 
 * @author thiag
 *
 */
public class FlightItineraryProblem {
	private static final int DESTINATION = 1;
	private static final int ORIGIN = 0;

	public static String findItinerary(String[][] flights, String origin) {
		Map<String, String> flightMap = new HashMap();
		for (String[] flight : flights) {
			flightMap.put(flight[ORIGIN], flight[DESTINATION]);
		}
		
		int count = 0;
		
		String destination = flightMap.get(origin);
		
		StringBuilder itinerary = new StringBuilder();
		itinerary.append(origin);
		
		while (destination != null && count <= flights.length) {
			count++;
			
			itinerary.append(", " + destination);
			
			String newOrigin = destination;
			
			destination = flightMap.get(newOrigin);
		}
		
		return count == flights.length ? itinerary.toString() : null;		
	}
}
