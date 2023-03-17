package com.trainings.algorithms.arrays;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShortestPathInAMatrixTest {
    @Test
    public void testOne() {
        assertEquals("1->3->10->1", new ShortestPathInAMatrix().shortestPath(new int[][]{{1,20, 3}, {3,10, 1}}));
    }
}