package com.trainings.algorithms.arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SearchA2DMatrixTest {
    @Test
    public void testOne() {
        int[][] matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 3;
        assertEquals(true, new SearchA2DMatrix().searchMatrix(matrix, target));
    }
}