package com.trainings.algorithms.arrays;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class ReverseStringTest {

	@Test
	void test() {
		ReverseString reverseString = new ReverseString();
		Assert.assertEquals("zarreF ogaihT", reverseString.reverse("Thiago Ferraz"));
		Assert.assertNull(reverseString.reverse(null));
		Assert.assertTrue(reverseString.reverse("").isEmpty());
	}

}
