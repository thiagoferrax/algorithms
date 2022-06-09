package com.trainings.algorithms.sorting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.trainings.algorithms.sorting.MergeKSortedLists.ListNode;

class MergeKSortedListsTest {

	@Test
	void test() {
		// Given
		// Input: lists = [[1,4,5],[1,3,4],[2,6]]
		MergeKSortedLists l = new MergeKSortedLists();
		ListNode[] lists = { l.new ListNode(1, l.new ListNode(4, l.new ListNode(5, null))),
				l.new ListNode(1, l.new ListNode(3, l.new ListNode(4, null))),
				l.new ListNode(2, l.new ListNode(6, null)) };

		// When
		ListNode mergeKLists = l.mergeKLists(lists);

		// Then
		// Output: [1,1,2,3,4,4,5,6]
		ListNode expected = l.new ListNode(1, l.new ListNode(1, l.new ListNode(2,
				l.new ListNode(3, l.new ListNode(4, l.new ListNode(4, l.new ListNode(5, l.new ListNode(6, null))))))));

		assertEquals(expected, mergeKLists);
	}

	@Test
	void testEmptyInput() {
		// Given
		// Input: lists = [[1,4,5],[1,3,4],[2,6]]
		MergeKSortedLists l = new MergeKSortedLists();
		ListNode[] lists = new ListNode[] {};

		// When
		ListNode mergeKLists = l.mergeKLists(lists);

		// Then
		// Output: [1,1,2,3,4,4,5,6]

		assertEquals(null, mergeKLists);
	}

}
