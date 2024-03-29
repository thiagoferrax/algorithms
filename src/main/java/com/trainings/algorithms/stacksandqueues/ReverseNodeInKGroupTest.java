package com.trainings.algorithms.stacksandqueues;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

class ReverseNodeInKGroupTest {
    @Test
    void testHappyDay() {
        ReverseNodeInKGroup r = new ReverseNodeInKGroup();

        assertEquals(r.new ListNode(2, r.new ListNode(1, r.new ListNode(4, r.new ListNode(3, r.new ListNode(5))))), r.reverseKGroup(
                r.new ListNode(1, r.new ListNode(2, r.new ListNode(3, r.new ListNode(4, r.new ListNode(5, null))))),
                2));
    }

}
