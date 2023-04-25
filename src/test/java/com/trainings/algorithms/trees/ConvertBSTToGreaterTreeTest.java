package com.trainings.algorithms.trees;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConvertBSTToGreaterTreeTest {
    @Test
    public void testOne() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);

        TreeNode greaterTree = new TreeNode(21);
        greaterTree.left = new TreeNode(20);
        greaterTree.left.left = new TreeNode(15);
        greaterTree.left.right = new TreeNode(11);
        greaterTree.right = new TreeNode(18);
        greaterTree.right.left = new TreeNode(6);

        assertEquals(greaterTree, new ConvertBSTToGreaterTree().convertBST(root));
    }

}