package com.trainings.algorithms.trees;

import org.junit.Assert;
import org.junit.Test;


public class BSTLevelOrderTraversalTest {

    @Test
    public void whenRootIsNullShouldReturnNull() {
        Node root = null;
        Assert.assertNull(BSTLevelOrderTraversal.getLevelOrder(root));
    }

    @Test
    public void whenRootIsNotNullShouldReturnAnStringWithCorrectNodeOrder() {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(12);

        Assert.assertEquals("10 8 12", BSTLevelOrderTraversal.getLevelOrder(root));
    }

}
