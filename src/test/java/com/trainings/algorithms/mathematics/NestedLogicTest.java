package com.trainings.algorithms.mathematics;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class NestedLogicTest {

	@Test
	void testAfterSameMonthAndYear() {		
		Assert.assertEquals(45, NestedLogic.calculateFine(getDate(9, 6, 2015), getDate(6, 6, 2015)));
	}
	
	@Test
	void testAfterSameYear() {		
		Assert.assertEquals(1500, NestedLogic.calculateFine(getDate(9, 9, 2015), getDate(6, 6, 2015)));
	}
	
	@Test
	void testAfterYear() {		
		Assert.assertEquals(10000, NestedLogic.calculateFine(getDate(9, 9, 2016), getDate(6, 6, 2015)));
	}

	private Calendar getDate(int day, int month, int year) {
		Calendar actual = Calendar.getInstance();
		actual.set(Calendar.DAY_OF_MONTH, day);
		actual.set(Calendar.MONTH, month - 1);
		actual.set(Calendar.YEAR, year);
		return actual;
	}

}
