package com.trainings.algorithms.arrays;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShortestPathInAMatrixTest {
    @Test
    public void testOne() {
        assertEquals("1->3->10->1", new ShortestPathInAMatrix().shortestPath(new int[][]{{1,20, 3}, {3,10, 1}}));
    }

    @Test
    public void testTwo() {
        assertEquals("2->10->1->4->2->1->1", new ShortestPathInAMatrix().shortestPath(new int[][]{{2,10, 1, 3}, {10,5, 4, 5}, {2, 10, 2, 1}, {25, 2, 5, 1}}));
    }
}