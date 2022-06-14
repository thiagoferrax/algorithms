package com.trainings.algorithms.dynamicprogramming;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class KnapsackTest {

	@Test
	void test() {
		Knapsack ks = new Knapsack();
		int[] profits = { 1, 6, 10, 16 };
		int[] weights = { 1, 2, 3, 5 };

		assertEquals(22, ks.solveKnapsack(profits, weights, 7));
		assertEquals(17, ks.solveKnapsack(profits, weights, 6));
	}

}
