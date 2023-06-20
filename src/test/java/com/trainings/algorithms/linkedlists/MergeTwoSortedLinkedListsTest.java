package com.trainings.algorithms.linkedlists;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergeTwoSortedLinkedListsTest {
    @Test
    public void example1(){
        MergeTwoSortedLinkedLists.SinglyLinkedListNode head1 = new MergeTwoSortedLinkedLists.SinglyLinkedListNode(1);
        head1.next = new MergeTwoSortedLinkedLists.SinglyLinkedListNode(3);
        head1.next.next = new MergeTwoSortedLinkedLists.SinglyLinkedListNode(7);

        MergeTwoSortedLinkedLists.SinglyLinkedListNode head2 = new MergeTwoSortedLinkedLists.SinglyLinkedListNode(1);
        head2.next = new MergeTwoSortedLinkedLists.SinglyLinkedListNode(2);

        MergeTwoSortedLinkedLists.SinglyLinkedListNode mergedList = new MergeTwoSortedLinkedLists.SinglyLinkedListNode(1);
        mergedList.next = new MergeTwoSortedLinkedLists.SinglyLinkedListNode(1);
        mergedList.next.next = new MergeTwoSortedLinkedLists.SinglyLinkedListNode(2);
        mergedList.next.next.next = new MergeTwoSortedLinkedLists.SinglyLinkedListNode(3);
        mergedList.next.next.next.next = new MergeTwoSortedLinkedLists.SinglyLinkedListNode(7);
        assertEquals(mergedList, MergeTwoSortedLinkedLists.mergeLists(head1, head2));
    }
}