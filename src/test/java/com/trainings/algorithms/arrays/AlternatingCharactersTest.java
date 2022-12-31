package com.trainings.algorithms.arrays;

import org.junit.Assert;
import org.junit.Test;

public class AlternatingCharactersTest {

    @Test
    public void testHappyDay() {
        Assert.assertEquals(4, AlternatingCharacters.alternatingCharacters("AAABABBABBAB"));
    }

}
