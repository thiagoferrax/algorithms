package com.trainings.algorithms.trees;

import org.junit.Test;

import static org.junit.Assert.*;

public class TreePreorderTraversalTest {
    @Test
    public void example1(){
        Node root = new Node(5);
        root.left = new Node(3);
        root.left.left = new Node(2);
        root.left.left.left = new Node(1);
        root.left.right = new Node(4);

        root.right = new Node(7);
        root.right.left = new Node(6);
        root.right.right = new Node(8);

        assertEquals("5 3 2 1 4 7 6 8", TreePreorderTraversal.preOrder(root));
    }
}