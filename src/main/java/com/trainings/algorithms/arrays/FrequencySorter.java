package com.trainings.algorithms.arrays;

import java.util.*;

public class FrequencySorter {
    public int[] order(int[] numbers) {
        if (numbers == null) return null;
        if (numbers.length <= 1) return numbers.clone();

        Map<Integer, Integer> frequency = new HashMap<>();
        for (int number: numbers) {
            frequency.put(number, frequency.getOrDefault(number, 0) + 1);
        }

        int[] ordered = numbers.clone();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                if((frequency.get(ordered[j]) > frequency.get(ordered[i])) ||
                        (Objects.equals(frequency.get(ordered[j]), frequency.get(ordered[i]))
                                && ordered[j] > ordered[i])) {
                    switchValues(ordered, j, i);
                }
            }
        }

        return ordered;
    }

    private static void switchValues(int[] ordered, int j, int i) {
        int temp = ordered[j];
        ordered[j] = ordered[i];
        ordered[i] = temp;
    }
}




