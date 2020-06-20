package com.trainings.algorithms.https;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


class TransactionsByLocationAndIdTest {

	@Test
	void test() {

		int userId = 2;
		int locationId = 8;
		int netStart = 119;
		int netEnd = 212;
		
		Assert.assertEquals(-6473, Result.getTransactions(userId, locationId, netStart, netEnd));

	}

}
