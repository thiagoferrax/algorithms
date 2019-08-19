package com.trainings.algorithms.technicaltest;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


class MaxOccurrenceWordsTest {

	@Test
	void test() {
		String text = "Falling down balloon Falling down balloon, Falling down balloon It falls here in my hand!";
		int n = 3;
		Assert.assertEquals(new ArrayList<String>(Arrays.asList("balloon", "down", "falling")), MaxOccurrenceWords.findMaxOccurrences(text, n));
	}

}
