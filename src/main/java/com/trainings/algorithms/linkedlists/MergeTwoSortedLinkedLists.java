package com.trainings.algorithms.linkedlists;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
public class MergeTwoSortedLinkedLists {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SinglyLinkedListNode that = (SinglyLinkedListNode) o;
            return data == that.data && Objects.equals(next, that.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data, next);
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        List<Integer> values = new ArrayList<>();

        buildValues(head1, values);
        buildValues(head2, values);

        values.sort((a, b) -> b - a);

        SinglyLinkedListNode node = null;
        for(Integer value : values) {
            SinglyLinkedListNode current = new SinglyLinkedListNode(value);
            current.next = node;
            node = current;
        }

        return  node;
    }

    private static void buildValues(SinglyLinkedListNode head1, List<Integer> values) {
        SinglyLinkedListNode node = head1;
        while(node!=null) {
            values.add(node.data);
            node = node.next;
        }
    }

}
