package com.trainings.algorithms.technicaltest;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;


public class MaxOccurrenceWordsTest {

    @Test
    public void test() {
        String text = "Falling down balloon, Falling down balloon, Falling down balloon. It falls here in my hand!";
        Assert.assertEquals(new ArrayList<String>(Arrays.asList("down", "falling", "balloon")), MaxOccurrenceWords.findMaxOccurrences(text, 3));
    }

}
