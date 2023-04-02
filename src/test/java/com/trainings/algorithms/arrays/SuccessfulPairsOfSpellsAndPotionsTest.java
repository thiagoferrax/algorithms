package com.trainings.algorithms.arrays;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SuccessfulPairsOfSpellsAndPotionsTest {
    @Test
    public void testOne() {
        assertEquals(Arrays.toString(new int[]{4, 0, 3}), Arrays.toString(new SuccessfulPairsOfSpellsAndPotions().successfulPairs(new int[]{5, 1, 3}, new int[]{1, 2, 3, 4, 5}, 7)));
    }

    @Test
    public void testTwo() {
        assertEquals(Arrays.toString(new int[]{1, 1, 1}), Arrays.toString(new SuccessfulPairsOfSpellsAndPotions().successfulPairs(new int[]{15, 14, 39}, new int[]{22}, 224)));
    }
}