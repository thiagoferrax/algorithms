package com.trainings.algorithms.trees;

import org.junit.Test;

import static org.junit.Assert.*;

public class TreeHeightOfABinaryTreeTest {

    @Test
    public void example1(){
        Node root = new Node(4);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(7);
        assertEquals(2, TreeHeightOfABinaryTree.height(root));
    }
}