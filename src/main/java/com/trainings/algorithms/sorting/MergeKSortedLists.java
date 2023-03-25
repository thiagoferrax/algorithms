package com.trainings.algorithms.sorting;

import java.util.*;

// https://leetcode.com/problems/merge-k-sorted-lists/	
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        final List<Integer> values = new ArrayList<>();
        for (ListNode node : lists) {
            while (node != null) {
                values.add(node.val);
                node = node.next;
            }
        }

        values.sort((a, b) -> b - a);

        ListNode next = null;
        ListNode node = null;

        Iterator<Integer> iterator = values.iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            node = new ListNode(value);

            node.next = next;
            next = node;
        }

        return node;
    }

    public ListNode mergeKLists2ndSolution(ListNode[] lists) {

        TreeMap<Integer, ListNode> sortedMap = Arrays.stream(lists).reduce(
                new TreeMap<Integer, ListNode>((a, b) -> b - a), (map, b) -> buildMap(map, b),
                (map, updatedMap) -> updatedMap);

        ListNode next = null;
        ListNode node = null;

        Iterator<ListNode> iterator = sortedMap.values().iterator();
        while (iterator.hasNext()) {
            node = iterator.next();

            ListNode current = node;
            while (current.next != null) {
                current = current.next;
            }
            current.next = next;
            next = node;
        }

        return node;
    }

    public TreeMap<Integer, ListNode> buildMap(TreeMap<Integer, ListNode> map, ListNode node) {
        if (node != null) {
            ListNode listNode = map.get(node.val);

            if (listNode == null) {
                map.put(node.val, new ListNode(node.val, null));
            } else {
                ListNode current = listNode;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = new ListNode(node.val, null);
            }
            buildMap(map, node.next);
        }

        return map;
    }

    public ListNode mergeKLists1stSolution(ListNode[] lists) {

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

}
