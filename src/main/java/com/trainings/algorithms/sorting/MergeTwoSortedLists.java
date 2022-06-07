package com.trainings.algorithms.sorting;

import java.util.Objects;

// https://leetcode.com/problems/merge-two-sorted-lists
public class MergeTwoSortedLists {

	class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + Objects.hash(next, val);
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ListNode other = (ListNode) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			return Objects.equals(next, other.next) && val == other.val;
		}

		private MergeTwoSortedLists getEnclosingInstance() {
			return MergeTwoSortedLists.this;
		}

		@Override
		public String toString() {
			return "ListNode [val=" + val + ", next=" + next + "]";
		}
	}

	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode one = list1;
		ListNode two = list2;

		if (endOfAllLists(one, two)) {
			return null;
		}

		ListNode merged = new ListNode(0, null);
		ListNode head = merged;

		while (!endOfAllLists(one, two)) {
			if (one == null) {
				merged.val = two.val;
				two = two.next;
			} else if (two == null) {
				merged.val = one.val;
				one = one.next;
			} else if (one.val <= two.val) {
				merged.val = one.val;
				one = one.next;
			} else {
				merged.val = two.val;
				two = two.next;
			}

			if (!endOfAllLists(one, two)) {
				merged.next = new ListNode(0, null);
				merged = merged.next;
			}
		}

		return head;
	}

	private boolean endOfAllLists(ListNode one, ListNode two) {
		return one == null && two == null;
	}

}
