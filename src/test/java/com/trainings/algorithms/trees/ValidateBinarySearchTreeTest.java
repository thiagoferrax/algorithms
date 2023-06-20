package com.trainings.algorithms.trees;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidateBinarySearchTreeTest {
    @Test
    public void example1(){
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        assertEquals(true, new ValidateBinarySearchTree().isValidBST(root));
    }
    @Test
    public void example2(){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);

        assertEquals(false, new ValidateBinarySearchTree().isValidBST(root));
    }

    @Test
    public void example3(){
        TreeNode root = new TreeNode(120);
        root.left = new TreeNode(70);
        root.left.left = new TreeNode(50);
        root.left.left.left = new TreeNode(20);
        root.left.left.right = new TreeNode(55);

        root.left.right = new TreeNode(100);
        root.left.right.left = new TreeNode(75);
        root.left.right.right = new TreeNode(110);

        root.right = new TreeNode(140);
        root.right.left = new TreeNode(130);
        root.right.left.left = new TreeNode(119);
        root.right.left.right = new TreeNode(135);

        root.right.right = new TreeNode(160);
        root.right.right.left = new TreeNode(150);
        root.right.right.right = new TreeNode(200);



        assertEquals(false, new ValidateBinarySearchTree().isValidBST(root));
    }
}