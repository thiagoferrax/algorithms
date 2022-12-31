package com.trainings.algorithms.stacksandqueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

//https://leetcode.com/problems/reverse-nodes-in-k-group/
public class ReverseNodeInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        ListNode currentNode = head;

        ListNode[] ascending = new ListNode[k];
        ListNode[] descending = new ListNode[k];

        List<ListNode> nodes = new ArrayList<>();

        int count = 0;
        while (currentNode != null) {
            if (count < k) {
                ListNode newNode = new ListNode(currentNode.val, null);
                ascending[count] = newNode;
                descending[k - count - 1] = newNode;
            }
            count++;
            if (count == k) {
                nodes.addAll(new ArrayList<ListNode>(Arrays.asList(descending)));

                ascending = new ListNode[k];
                descending = new ListNode[k];

                count = 0;
            }
            currentNode = currentNode.next;

            if (currentNode == null && count < k) {
                nodes.addAll(new ArrayList<ListNode>(Arrays.asList(ascending)));
            }
        }

        ListNode next = null;
        ListNode node = null;
        for (int i = nodes.size() - 1; i >= 0; i--) {
            node = nodes.get(i);
            if (node != null) {
                node.next = next;
                next = node;
            }

        }

        return node;

    }

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

        private ReverseNodeInKGroup getEnclosingInstance() {
            return ReverseNodeInKGroup.this;
        }

    }

}
