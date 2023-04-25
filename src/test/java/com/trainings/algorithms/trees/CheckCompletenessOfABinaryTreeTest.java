package com.trainings.algorithms.trees;

import junit.framework.TestCase;
import org.junit.Test;

public class CheckCompletenessOfABinaryTreeTest extends TestCase {
    @Test
    public void testOne() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);

        assertEquals(true, new CheckCompletenessOfABinaryTree().isCompleteTree(root));
    }


}