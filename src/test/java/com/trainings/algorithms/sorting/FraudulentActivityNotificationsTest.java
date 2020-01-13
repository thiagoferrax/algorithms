package com.trainings.algorithms.sorting;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class FraudulentActivityNotificationsTest {

	@Test
	void test() {
		Assert.assertEquals(3, FraudulentActivityNotifications.activityNotifications(new int[] { 0, 20, 30, 10, 40, 50, 60, 100 }, 4));
		Assert.assertEquals(2, FraudulentActivityNotifications.activityNotifications(new int[] { 10, 20, 30, 40, 50, 60, 100 }, 3));
		Assert.assertEquals(2, FraudulentActivityNotifications.activityNotifications(new int[] { 100, 50, 60, 40, 100, 20, 80 }, 3));
		Assert.assertEquals(3, FraudulentActivityNotifications.activityNotifications(new int[] { 30, 10, 20, 40, 50, 60, 100 }, 3));
		Assert.assertEquals(1, FraudulentActivityNotifications.activityNotifications(new int[] { 10, 20, 30, 40, 50, 60, 5 }, 4));
		Assert.assertEquals(0, FraudulentActivityNotifications.activityNotifications(new int[] { 1, 2, 3, 4, 4 }, 4));
		Assert.assertEquals(2, FraudulentActivityNotifications.activityNotifications(new int[] { 2, 3, 4, 2, 3, 6, 8, 4, 5 }, 5));
		Assert.assertEquals(2, FraudulentActivityNotifications.activityNotifications(new int[] { 2, 3, 4, 2, 3, 6, 8, 4, 5 }, 3));
		Assert.assertEquals(2, FraudulentActivityNotifications.activityNotifications(new int[] { 2, 3, 4, 2, 3, 6, 8}, 4));
		Assert.assertEquals(1, FraudulentActivityNotifications.activityNotifications(new int[] { 2, 3, 4, 2, 3, 6, 3}, 4));
		Assert.assertEquals(2, FraudulentActivityNotifications.activityNotifications(new int[] { 2, 2, 4, 2, 3, 6, 3}, 2));
		Assert.assertEquals(5, FraudulentActivityNotifications.activityNotifications(new int[] { 1, 2, 4, 2, 4, 8, 16}, 1));
		Assert.assertEquals(1, FraudulentActivityNotifications.activityNotifications(new int[] { 16, 8, 4, 2, 4, 2, 1}, 1));
		Assert.assertEquals(0, FraudulentActivityNotifications.activityNotifications(new int[] { 2, 2, 2, 2, 2, 2, 2}, 1));
		Assert.assertEquals(6, FraudulentActivityNotifications.activityNotifications(new int[] { 2, 4, 8, 16, 32, 64, 128}, 1));
	}

}