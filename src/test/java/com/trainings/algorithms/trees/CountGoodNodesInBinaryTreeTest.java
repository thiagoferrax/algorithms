package com.trainings.algorithms.trees;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountGoodNodesInBinaryTreeTest {

    @Test
    public void testOne() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.left.right = null;
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        assertEquals(4, new CountGoodNodesInBinaryTree().goodNodes(root));
    }

}