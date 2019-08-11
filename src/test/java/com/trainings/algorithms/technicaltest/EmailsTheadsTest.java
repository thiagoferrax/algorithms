package com.trainings.algorithms.technicaltest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class EmailsTheadsTest {

	@Test
	void test() {
		List<String> emails = new ArrayList<String>();
		
		emails.add("abc@gmail.com, x@gmail.com, hello x, how are you?");
		emails.add("c@gmail.com, abc@gmail.com, did you take a look at the event?");
		emails.add("x@gmail.com, abc@gmail.com, i am great. how are you?---hello x, how are you?");
		
		List<List<Integer>> expecteds = new ArrayList<List<Integer>>();
		expecteds.add(Arrays.asList(1, 1));
		expecteds.add(Arrays.asList(2, 1));
		expecteds.add(Arrays.asList(1, 2));

		Assert.assertEquals(expecteds, Result.getEmailThreads(emails));
	}
	
	

}
