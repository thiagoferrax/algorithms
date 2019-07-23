package com.trainings.algorithms.arrays;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class FirstRecurringTest {

	@Test
	void whenPassingANullOrEmptyArrayReturnsNull() {
		FirstRecurring firstRecurring = new FirstRecurring();
		Assert.assertNull(firstRecurring.getFirstRecurring(null));
		Assert.assertNull(firstRecurring.getFirstRecurring(new int[] {}));
	}
	
	@Test
	void whenPassingANotEmptyArrayWithARecurringValueReturnsIt() {
		FirstRecurring firstRecurring = new FirstRecurring();
		Assert.assertEquals(new Integer(2), firstRecurring.getFirstRecurring(new int[] {2, 5, 1, 2, 3}));
	}

}
