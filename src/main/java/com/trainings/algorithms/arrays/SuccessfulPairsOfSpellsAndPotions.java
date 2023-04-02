package com.trainings.algorithms.arrays;

import java.util.Arrays;

public class SuccessfulPairsOfSpellsAndPotions {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] successfulPairs = new int[spells.length];

        int[] pairs = new int[spells.length * potions.length];
        int s = 0, count = 0;
        for (int i = 0; i < pairs.length; i++) {
            pairs[i] = potions[i%potions.length];
        }

        System.out.println(Arrays.toString(pairs));

        for (int i = 0; i < pairs.length; i++) {
            pairs[i] *= spells[s];

            if(pairs[i] >= success) {
                count++;
            }

            if((i + 1) % potions.length == 0) {
                successfulPairs[s] = count;
                s++;
                count = 0;
            }
        }

        System.out.println(Arrays.toString(pairs));

        return successfulPairs;
    }

    public int[] successfulPairs1stSolution(int[] spells, int[] potions, long success) {
        int[] successfulPairs = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {
            successfulPairs[i] = 0;
            for (int potion : potions) {
                if (((long) spells[i] * potion) >= success) successfulPairs[i]++;
            }
        }

        return successfulPairs;
    }

}
