package com.trainings.algorithms.trees;

import org.junit.Assert;
import org.junit.Test;


public class BSTDepthPreOrderTraversalTest {

    @Test
    public void test() {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(14);
        root.right.left = new Node(11);
        root.right.left.right = new Node(12);

        Assert.assertArrayEquals(new Integer[]{10, 8, 14, 11, 12}, BSTDepthPreOrderTraversal.traversal(root));
    }

}
