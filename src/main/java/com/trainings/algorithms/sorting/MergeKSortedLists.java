package com.trainings.algorithms.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MergeKSortedLists {

	public class ListNode {
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
		public String toString() {
			return "ListNode [val=" + val + ", next=" + next + "]";
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

		private MergeKSortedLists getEnclosingInstance() {
			return MergeKSortedLists.this;
		}

	}

	public ListNode mergeKLists(ListNode[] lists) {

		List<ListNode> asList = new ArrayList<ListNode>(Arrays.asList(lists));

		ListNode head = null;
		ListNode headNext = null;
		ListNode minLN = null;

		while (!asList.isEmpty()) {
			ListNode min = asList.stream().filter(l -> l != null).min((a, b) -> a.val - b.val).get();

			if (min != null) {
				minLN = new ListNode(min.val, null);

				if (head == null) {
					head = minLN;
					headNext = head;
				} else {
					headNext.next = minLN;
					headNext = headNext.next;
				}
				minLN = null;
				asList.remove(min);
				if (min.next != null) {
					asList.add(min.next);
				}
			}
		}

		return head;
	}
}
