package com.trainings.algorithms.https;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


class TransactionsByLocationAndIdTest {

	@Test
	void test1() {
		Assert.assertEquals(-6474, Result.getTransactions(2, 8, 119, 212));

	}

	@Test
	void test2() {
		Assert.assertEquals(2549, Result.getTransactions(4, 6, 100, 250));
	}

	@Test
	void test3() {
		Assert.assertEquals(0, Result.getTransactions(1, 9, 25, 75));
	}
	
	@Test
	void test4() {
		Assert.assertEquals(0, Result.getTransactions(2, 8, 5, 50));
	}
	
	@Test
	void test5() {
		Assert.assertEquals(-1101, Result.getTransactions(1, 9, 100, 220));
	}
}
