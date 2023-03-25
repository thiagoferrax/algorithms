package com.trainings.algorithms.sorting;

import com.trainings.algorithms.sorting.MergeTwoSortedLists.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

class MergeTwoSortedListsTest {

    @Test
    void test() {
        // Given
        MergeTwoSortedLists merge = new MergeTwoSortedLists();

        ListNode one = merge.new ListNode(1, merge.new ListNode(2, merge.new ListNode(4, null)));
        ListNode two = merge.new ListNode(1, merge.new ListNode(3, merge.new ListNode(4, null)));

        // When
        ListNode mergeTwoLists = merge.mergeTwoLists(one, two);

        // Then

        ListNode expectedMerge = merge.new ListNode(1, merge.new ListNode(1,
                merge.new ListNode(2, merge.new ListNode(3, merge.new ListNode(4, merge.new ListNode(4, null))))));

        assertEquals(expectedMerge, mergeTwoLists);
    }

}
