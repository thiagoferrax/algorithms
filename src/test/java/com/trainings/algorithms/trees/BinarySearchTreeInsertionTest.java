package com.trainings.algorithms.trees;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeInsertionTest {
    @Test
    public void example1(){
        Node root = new Node(4);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right = new Node(7);

        Node expected = new Node(4);
        expected.left = new Node(2);
        expected.left.left = new Node(1);
        expected.left.right = new Node(3);
        expected.right = new Node(7);
        expected.right.left = new Node(6);

        assertEquals(expected, BinarySearchTreeInsertion.insert(root, 6));
    }
}