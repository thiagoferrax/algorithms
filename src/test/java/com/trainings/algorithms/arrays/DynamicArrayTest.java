package com.trainings.algorithms.arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicArrayTest {

    @Test
    public void test() {
        List<List<Integer>> queries = new ArrayList<>();

        List<Integer> query1 = new ArrayList<Integer>();
        query1.addAll(Arrays.asList(1, 0, 5));

        List<Integer> query2 = new ArrayList<Integer>();
        query2.addAll(Arrays.asList(1, 1, 7));

        List<Integer> query3 = new ArrayList<Integer>();
        query3.addAll(Arrays.asList(1, 0, 3));

        List<Integer> query4 = new ArrayList<Integer>();
        query4.addAll(Arrays.asList(2, 1, 0));

        List<Integer> query5 = new ArrayList<Integer>();
        query5.addAll(Arrays.asList(2, 1, 1));

        queries.addAll(Arrays.asList(query1, query2, query3, query4, query5));

        Assert.assertArrayEquals(new Integer[]{7, 3}, DynamicArray.dynamicArray(2, queries).toArray());
    }

}
