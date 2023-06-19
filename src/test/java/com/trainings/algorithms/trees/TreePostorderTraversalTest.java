package com.trainings.algorithms.trees;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TreePostorderTraversalTest {
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

        assertEquals("1 2 4 3 6 8 7 5", TreePostorderTraversal.postOrder(root));
    }
}