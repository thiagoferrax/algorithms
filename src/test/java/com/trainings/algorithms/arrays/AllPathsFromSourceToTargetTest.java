package com.trainings.algorithms.arrays;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class AllPathsFromSourceToTargetTest {
    @Test
    public void testOne(){
        assertEquals(Arrays.asList(Arrays.asList(0,1,3), Arrays.asList(0,2,3)).toString(), new AllPathsFromSourceToTarget().allPathsSourceTarget(new int[][]  {{1,2},{3},{3},{}}).toString());
    }
}