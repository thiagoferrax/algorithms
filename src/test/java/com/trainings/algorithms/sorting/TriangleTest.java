package com.trainings.algorithms.sorting;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class TriangleTest {

	@Test
	void testFirstSolution() {
		Triangle triangle = new Triangle();
		Assert.assertEquals(1, triangle.firstSolution(new int[]{10, 2, 5, 1, 8, 20}));
		Assert.assertEquals(0, triangle.firstSolution(new int[]{10, 50, 5, 1}));
	}
	
	@Test
	void test() {
		Triangle triangle = new Triangle();
		Assert.assertEquals(1, triangle.solution(new int[]{10, 2, 5, 1, 8, 20}));
		Assert.assertEquals(0, triangle.solution(new int[]{10, 50, 5, 1}));
	}

	/*
	 * 0<=p<q<r<N
	 * 
	 * A[p] + A[q] > A[r] A[q] + A[r] > A[p] A[p] + A[r] > A[q]
	 * 
	 * Triplet(p=0, q=2, r=4) => A[0] 10 A[2] 5 A[4] 8
	 */
	
}
