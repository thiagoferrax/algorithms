package com.trainings.algorithms.countingelements;



import org.junit.Assert;
import org.junit.jupiter.api.Test;


class SwapElementsTest {

	@Test
	void test() {
		SwapElements swapElements = new SwapElements();
		Assert.assertEquals(0, swapElements.solution(new int[] {1, 2, 5}, new int[] {1, 2, 4}, 5));
		Assert.assertEquals(1, swapElements.solution(new int[] {1, 2, 1}, new int[] {2, 3, 5}, 5));
		Assert.assertEquals(1, swapElements.solution(new int[] {2}, new int[] {2}, 2));
		Assert.assertEquals(0, swapElements.solution(new int[] {2}, new int[] {3}, 3));
		Assert.assertEquals(1, swapElements.solution(new int[] {4, 3}, new int[] {2, 1}, 3));
	}

}
