package com.trainings.algorithms.arrays;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.Arrays;

public class FrequencySorterTest extends TestCase {

    public void testWithNoNumbersWithSameFrequency() {
        // Given
        int[] numbers = {1, 1, 2, 2, 2};

        // When
        FrequencySorter frequencySorter = new FrequencySorter();
        int[] order = frequencySorter.order(numbers);

        // Then
        Assert.assertEquals(
                Arrays.toString(new int[]{2, 2, 2, 1, 1}),
                Arrays.toString(order));

    }

    public void testWithNumbersWithSameFrequency() {
        // Given
        int[] numbers = {1, 1, 3, 3, 2, 2, 2};

        // When
        FrequencySorter frequencySorter = new FrequencySorter();
        int[] order = frequencySorter.order(numbers);

        // Then
        Assert.assertEquals(
                Arrays.toString(new int[]{2, 2, 2, 3, 3, 1, 1}),
                Arrays.toString(order));

    }

    public void testWithNullParameter() {
        // When
        FrequencySorter frequencySorter = new FrequencySorter();
        int[] order = frequencySorter.order(null);

        // Then
        Assert.assertNull(order);
    }

    public void testWithJustOneNumber() {
        // When
        FrequencySorter frequencySorter = new FrequencySorter();
        int[] order = frequencySorter.order(new int[]{9});

        // Then
        Assert.assertEquals(Arrays.toString(new int[]{9}), Arrays.toString(order));
    }

}