package com.trainings.algorithms.dictionariesandhashmaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class FrequencyQueriesTest {

	@Test
	void test() {
		List<List<Integer>> queries = new ArrayList<List<Integer>>();
		queries.add(Arrays.asList(1, 1));
		queries.add(Arrays.asList(2, 2));
		queries.add(Arrays.asList(3, 2));
		queries.add(Arrays.asList(1, 1));
		queries.add(Arrays.asList(1, 1));
		queries.add(Arrays.asList(2, 1));
		queries.add(Arrays.asList(3, 2));
		
		List<Integer> freqQuery = FrequencyQueries.freqQuery(queries );
	
		Assert.assertArrayEquals(Arrays.asList(0, 1).toArray(), freqQuery.toArray());
	}

}
