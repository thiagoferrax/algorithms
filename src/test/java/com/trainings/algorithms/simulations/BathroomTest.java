package com.trainings.algorithms.simulations;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class BathroomTest {
	
	@Test
	void getNextBath() {
		Assert.assertEquals(0, Bathroom.getNextBath(new int[]{ 7, 9, 7 }));
	}

}

