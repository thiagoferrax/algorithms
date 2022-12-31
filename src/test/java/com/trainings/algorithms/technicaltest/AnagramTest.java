package com.trainings.algorithms.technicaltest;

import org.junit.Assert;
import org.junit.Test;


public class AnagramTest {

    @Test
    public void test() {
        Assert.assertTrue(Anagram.isAnagram("AUTHOR", "OUTRHA"));
        Assert.assertFalse(Anagram.isAnagram("AUTHOR", "OUTRORA"));
        Assert.assertTrue(Anagram.isAnagram("BETTER", "RETTEB"));
    }

}
