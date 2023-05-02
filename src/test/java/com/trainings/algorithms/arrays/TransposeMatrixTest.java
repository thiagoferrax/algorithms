package com.trainings.algorithms.arrays;

import org.junit.Test;

import static org.junit.Assert.*;

public class TransposeMatrixTest {

    @Test
    public void testOne(){
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[][] transposeMatrix = new int[][]{{1,4,7},{2,5,8},{3,6,9}};
        assertEquals(transposeMatrix, new TransposeMatrix().transpose(matrix));
    }

    @Test
    public void testTwo(){
        int[][] matrix = new int[][]{{1,2,3},{4,5,6}};
        int[][] transposeMatrix = new int[][]{{1,4},{2,5},{3,6}};
        assertEquals(transposeMatrix, new TransposeMatrix().transpose(matrix));
    }

}