package com.trainings.algorithms.arrays;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class MatrixSpiralTest {

	@Test
	void test() {
		MatrixSpiral matrixSpiral = new MatrixSpiral();

		Assert.assertArrayEquals(new int[][] { { 1 } }, matrixSpiral.solution(1));
		Assert.assertArrayEquals(new int[][] { { 1, 2 }, { 4, 3 } }, matrixSpiral.solution(2));
		Assert.assertArrayEquals(new int[][] { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } }, matrixSpiral.solution(3));
		//Assert.assertArrayEquals(new int[][] { { 1, 2, 3, 4 }, { 12, 13, 14, 5 }, { 11, 16, 15, 6 }, { 10, 9, 8, 7 } }, matrixSpiral.solution(4));
	}

}
