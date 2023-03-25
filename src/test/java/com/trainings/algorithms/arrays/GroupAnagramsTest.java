package com.trainings.algorithms.arrays;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class GroupAnagramsTest {
    @Test
    public void test() {
        assertEquals(Arrays.asList(Arrays.asList("bat"),
                        Arrays.asList("nat", "tan"),
                        Arrays.asList("ate", "eat", "tea")),
                new GroupAnagrams().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}