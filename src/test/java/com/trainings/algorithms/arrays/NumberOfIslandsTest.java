package com.trainings.algorithms.arrays;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberOfIslandsTest {

	@Test
	public void test() {
		assertEquals(1, new NumberOfIslands().numIslands(
				new char[][] { { '1', '1', '1', '1', '0' },
							   { '1', '1', '0', '1', '0' }, 
							   { '1', '1', '0', '0', '0' }, 
							   { '0', '0', '0', '0', '0' }}));
	}
}
