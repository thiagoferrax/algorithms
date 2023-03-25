package com.trainings.algorithms.dictionariesandhashmaps;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FrequencyQueriesTest {

    @Test
    public void test() {
        List<int[]> queries = new ArrayList<int[]>();
        queries.add(new int[]{1, 1});
        queries.add(new int[]{2, 2});
        queries.add(new int[]{3, 2});
        queries.add(new int[]{1, 1});
        queries.add(new int[]{1, 1});
        queries.add(new int[]{2, 1});
        queries.add(new int[]{3, 2});

        List<Integer> freqQuery = FrequencyQueries.freqQuery(queries);

        Assert.assertArrayEquals(new Object[]{0, 1}, freqQuery.toArray());
    }

}
