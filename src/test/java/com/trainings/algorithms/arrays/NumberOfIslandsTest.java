package com.trainings.algorithms.arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberOfIslandsTest {

    @Test
    public void test() {
        assertEquals(1, new NumberOfIslands().numIslands(new char[][]{{'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}}));
    }

    @Test
    public void testTwo() {
        assertEquals(1, new NumberOfIslands()
                .numIslands(new char[][]{{'1', '1', '1'}, {'0', '1', '0',}, {'1', '1', '1',}}));
    }

    @Test
    public void testThree() {
        assertEquals(1, new NumberOfIslands().numIslands(new char[][]{
                {'1', '0', '1', '1', '1'},
                {'1', '0', '1', '0', '1'},
                {'1', '1', '1', '0', '1'}}));
    }

}
