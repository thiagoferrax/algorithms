package com.trainings.algorithms.trees;

import org.junit.Test;

import static org.junit.Assert.*;

public class SymmetricTreeTest {

    @Test
    public void testOne() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        assertEquals(true, new SymmetricTree().isSymmetric(root));
    }

    @Test
    public void testTwo() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = null;
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.left = null;
        root.right.right = new TreeNode(3);

        assertEquals(false, new SymmetricTree().isSymmetric(root));
    }

    //2,3,3,4,5,5,4,null,null,8,9,9,8
    @Test
    public void testThree() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.left.left = new TreeNode(9);
        root.right.left.right = new TreeNode(8);

        root.right.right = new TreeNode(4);

        assertEquals(true, new SymmetricTree().isSymmetric(root));
    }
}