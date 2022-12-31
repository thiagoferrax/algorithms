package com.trainings.algorithms.dictionariesandhashmaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Question #1: (Facebook) Given an unordered list of flights taken by someone,
 * each represented as (origin, destination) pairs, and a starting airport,
 * compute the person's itinerary. If no such itinerary exists, return null. If
 * there are multiple possible itineraries, return the lexicographically
 * smallest one. All flights must be used in the itinerary.
 * <p>
 * For example, given the list of flights [('SFO', 'HKO'), ('YYZ', 'SFO'),
 * ('YUL', 'YYZ'), ('HKO', 'ORD')] and starting airport 'YUL', you should return
 * the list ['YUL', 'YYZ', 'SFO', 'HKO', 'ORD'].
 * <p>
 * Given the list of flights [('SFO', 'COM'), ('COM', 'YYZ')] and starting
 * airport 'COM', you should return null.
 * <p>
 * Given the list of flights [('A', 'B'), ('A', 'C'), ('B', 'C'), ('C', 'A')]
 * and starting airport 'A', you should return the list ['A', 'B', 'C', 'A',
 * 'C'] even though ['A', 'C', 'A', 'B', 'C'] is also a valid itinerary.
 * However, the first one is lexicographically smaller.
 *
 * @author thiag
 */
public class FlightItineraryProblem {
    private static final int DESTINATION = 1;
    private static final int ORIGIN = 0;

    public static String findItinerary(String[][] flights, String origin) {
        Map<String, Map<String, Boolean>> flightMap = new HashMap<String, Map<String, Boolean>>();
        for (String[] flight : flights) {
            Map<String, Boolean> destionations = new HashMap<String, Boolean>();
            destionations.put(flight[DESTINATION], Boolean.FALSE);
            flightMap.put(flight[ORIGIN], destionations);
        }

        StringBuilder itinerary = new StringBuilder();
        findRoute(origin, flightMap, itinerary);
        String route = itinerary.toString();

        System.out.println(route);

        return route.split(",").length - 1 == flights.length ? route : null;
    }

    private static void findRoute(String origin, Map<String, Map<String, Boolean>> flightMap, StringBuilder itinerary) {
        append(origin, itinerary);

        Map<String, Boolean> destinations = flightMap.get(origin);
        if (destinations != null) {
            Set<Entry<String, Boolean>> entrySet = destinations.entrySet();
            for (Entry<String, Boolean> entry : entrySet) {
                String destinationKey = entry.getKey();
                Boolean alreadyVisited = entry.getValue();

                if (!alreadyVisited) {
                    destinations.put(destinationKey, Boolean.TRUE);
                    findRoute(destinationKey, flightMap, itinerary);
                }
            }
        }
    }

    private static void append(String origin, StringBuilder itinerary) {
        if (itinerary.length() > 0) {
            itinerary.append(", ");
        }
        itinerary.append(origin);
    }
}
