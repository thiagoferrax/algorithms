package com.trainings.algorithms.dictionariesandhashmaps;

import org.junit.Assert;
import org.junit.Test;


public class FlightItineraryProblemTest {

    @Test
    public void test() {
        String[][] flights = {{"SFO", "HKO"}, {"YYZ", "SFO"}, {"YUL", "YYZ"}, {"HKO", "ORD"}};
        Assert.assertEquals("YUL, YYZ, SFO, HKO, ORD", FlightItineraryProblem.findItinerary(flights, "YUL"));
    }

    @Test
    public void test2() {
        String[][] flights = {{"SFO", "COM"}, {"COM", "YYZ"}};
        Assert.assertNull(FlightItineraryProblem.findItinerary(flights, "COM"));
    }

    // Should reimplement the solution to attend this case.
    public void test3() {
        String[][] flights = {{"A", "B"}, {"A", "C"}, {"B", "C"}, {"C", "A"}};
        Assert.assertEquals("A, C, A, B, C", FlightItineraryProblem.findItinerary(flights, "A"));
    }
}
