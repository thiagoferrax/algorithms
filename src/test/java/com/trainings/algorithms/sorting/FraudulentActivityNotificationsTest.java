package com.trainings.algorithms.sorting;

import static com.trainings.algorithms.sorting.FraudulentActivityNotifications.activityNotifications;
import static com.trainings.algorithms.sorting.FraudulentActivityNotifications.activityNotificationsSecondSolution;
import static com.trainings.algorithms.sorting.FraudulentActivityNotifications.activityNotificationsThirdSolution;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class FraudulentActivityNotificationsTest {
	
	@Test
	void bigTest() {
		Assert.assertEquals(1, activityNotifications(new int[] { 0, 20, 30, 10, 40, 50, 60, 60, 50, 40, 10, 30, 20, 0 }, 3));
	}

	@Test
	void test() {
		Assert.assertEquals(3, activityNotifications(new int[] { 0, 20, 30, 10, 40, 50, 60, 100 }, 4));
		Assert.assertEquals(2, activityNotifications(new int[] { 10, 20, 30, 40, 50, 60, 100 }, 3));
		Assert.assertEquals(2, activityNotifications(new int[] { 100, 50, 60, 40, 100, 20, 80 }, 3));
		Assert.assertEquals(3, activityNotifications(new int[] { 30, 10, 20, 40, 50, 60, 100 }, 3));
		Assert.assertEquals(1, activityNotifications(new int[] { 30, 10, 40, 40, 40, 30, 80 }, 3));
		Assert.assertEquals(1, activityNotifications(new int[] { 10, 20, 30, 40, 50, 60, 5 }, 4));
		Assert.assertEquals(0, activityNotifications(new int[] { 1, 2, 3, 4, 4 }, 4));
		Assert.assertEquals(2, activityNotifications(new int[] { 2, 3, 4, 2, 3, 6, 8, 4, 5 }, 5));
		Assert.assertEquals(2, activityNotifications(new int[] { 2, 3, 4, 2, 3, 6, 8, 4, 5 }, 3));
		Assert.assertEquals(2, activityNotifications(new int[] { 2, 3, 4, 2, 3, 6, 8 }, 4));
		Assert.assertEquals(1, activityNotifications(new int[] { 2, 3, 4, 2, 3, 6, 3 }, 4));
		Assert.assertEquals(2, activityNotifications(new int[] { 2, 2, 4, 2, 3, 6, 3 }, 2));
		Assert.assertEquals(5, activityNotifications(new int[] { 1, 2, 4, 2, 4, 8, 16 }, 1));
		Assert.assertEquals(1, activityNotifications(new int[] { 16, 8, 4, 2, 4, 2, 1 }, 1));
		Assert.assertEquals(0, activityNotifications(new int[] { 2, 2, 2, 2, 2, 2, 2 }, 1));
		Assert.assertEquals(6, activityNotifications(new int[] { 2, 4, 8, 16, 32, 64, 128 }, 1));
	}

	@Test
	void testSecondSolution() {
		Assert.assertEquals(3, activityNotificationsSecondSolution(new int[] { 0, 20, 30, 10, 40, 50, 60, 100 }, 4));
		Assert.assertEquals(2, activityNotificationsSecondSolution(new int[] { 10, 20, 30, 40, 50, 60, 100 }, 3));
		Assert.assertEquals(2, activityNotificationsSecondSolution(new int[] { 100, 50, 60, 40, 100, 20, 80 }, 3));
		Assert.assertEquals(3, activityNotificationsSecondSolution(new int[] { 30, 10, 20, 40, 50, 60, 100 }, 3));
		Assert.assertEquals(1, activityNotificationsSecondSolution(new int[] { 30, 10, 40, 40, 40, 30, 80 }, 3));
		Assert.assertEquals(1, activityNotificationsSecondSolution(new int[] { 10, 20, 30, 40, 50, 60, 5 }, 4));
		Assert.assertEquals(0, activityNotificationsSecondSolution(new int[] { 1, 2, 3, 4, 4 }, 4));
		Assert.assertEquals(2, activityNotificationsSecondSolution(new int[] { 2, 3, 4, 2, 3, 6, 8, 4, 5 }, 5));
		Assert.assertEquals(2, activityNotificationsSecondSolution(new int[] { 2, 3, 4, 2, 3, 6, 8, 4, 5 }, 3));
		Assert.assertEquals(2, activityNotificationsSecondSolution(new int[] { 2, 3, 4, 2, 3, 6, 8 }, 4));
		Assert.assertEquals(1, activityNotificationsSecondSolution(new int[] { 2, 3, 4, 2, 3, 6, 3 }, 4));
		Assert.assertEquals(2, activityNotificationsSecondSolution(new int[] { 2, 2, 4, 2, 3, 6, 3 }, 2));
		Assert.assertEquals(5, activityNotificationsSecondSolution(new int[] { 1, 2, 4, 2, 4, 8, 16 }, 1));
		Assert.assertEquals(1, activityNotificationsSecondSolution(new int[] { 16, 8, 4, 2, 4, 2, 1 }, 1));
		Assert.assertEquals(0, activityNotificationsSecondSolution(new int[] { 2, 2, 2, 2, 2, 2, 2 }, 1));
		Assert.assertEquals(6, activityNotificationsSecondSolution(new int[] { 2, 4, 8, 16, 32, 64, 128 }, 1));
	}
	
	@Test
	void testThirdSolution() {
		Assert.assertEquals(3, activityNotificationsThirdSolution(new int[] { 0, 20, 30, 10, 40, 50, 60, 100 }, 4));
		Assert.assertEquals(2, activityNotificationsThirdSolution(new int[] { 10, 20, 30, 40, 50, 60, 100 }, 3));
		Assert.assertEquals(2, activityNotificationsThirdSolution(new int[] { 100, 50, 60, 40, 100, 20, 80 }, 3));
		Assert.assertEquals(3, activityNotificationsThirdSolution(new int[] { 30, 10, 20, 40, 50, 60, 100 }, 3));
		Assert.assertEquals(1, activityNotificationsThirdSolution(new int[] { 30, 10, 40, 40, 40, 30, 80 }, 3));
		Assert.assertEquals(1, activityNotificationsThirdSolution(new int[] { 10, 20, 30, 40, 50, 60, 5 }, 4));
		Assert.assertEquals(0, activityNotificationsThirdSolution(new int[] { 1, 2, 3, 4, 4 }, 4));
		Assert.assertEquals(2, activityNotificationsThirdSolution(new int[] { 2, 3, 4, 2, 3, 6, 8, 4, 5 }, 5));
		Assert.assertEquals(2, activityNotificationsThirdSolution(new int[] { 2, 3, 4, 2, 3, 6, 8, 4, 5 }, 3));
		Assert.assertEquals(2, activityNotificationsThirdSolution(new int[] { 2, 3, 4, 2, 3, 6, 8 }, 4));
		Assert.assertEquals(1, activityNotificationsThirdSolution(new int[] { 2, 3, 4, 2, 3, 6, 3 }, 4));
		Assert.assertEquals(2, activityNotificationsThirdSolution(new int[] { 2, 2, 4, 2, 3, 6, 3 }, 2));
		Assert.assertEquals(5, activityNotificationsThirdSolution(new int[] { 1, 2, 4, 2, 4, 8, 16 }, 1));
		Assert.assertEquals(1, activityNotificationsThirdSolution(new int[] { 16, 8, 4, 2, 4, 2, 1 }, 1));
		Assert.assertEquals(0, activityNotificationsThirdSolution(new int[] { 2, 2, 2, 2, 2, 2, 2 }, 1));
		Assert.assertEquals(6, activityNotificationsThirdSolution(new int[] { 2, 4, 8, 16, 32, 64, 128 }, 1));
	}

}