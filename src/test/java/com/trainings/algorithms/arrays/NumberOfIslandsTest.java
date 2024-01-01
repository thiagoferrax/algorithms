package com.trainings.algorithms.arrays;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberOfIslandsTest {

    @Ignore
    @Test
    public void test() {
        assertEquals(1, new NumberOfIslands().numIslands(new char[][]{{'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}}));
    }

    @Ignore
    @Test
    public void testTwo() {
        assertEquals(1, new NumberOfIslands()
                .numIslands(new char[][]{{'1', '1', '1'}, {'0', '1', '0',}, {'1', '1', '1',}}));
    }

    @Ignore
    @Test
    public void testThree() {
        assertEquals(1, new NumberOfIslands().numIslands(new char[][]{
                {'1', '0', '1', '1', '1'},
                {'1', '0', '1', '0', '1'},
                {'1', '1', '1', '0', '1'}}));
    }

}
