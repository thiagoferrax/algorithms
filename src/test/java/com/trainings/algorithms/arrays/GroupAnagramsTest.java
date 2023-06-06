package com.trainings.algorithms.arrays;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GroupAnagramsTest {
    @Test
    public void test() {
        assertEquals(Arrays.asList(List.of("eat", "tea", "ate"),
                        List.of("bat"), List.of("tan", "nat")),
                new GroupAnagrams().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}