package com.trainings.algorithms.trees;

import org.junit.Test;

import static org.junit.Assert.*;

public class SerializeAndDeserializeBinaryTreeTest {
    @Test
    public void testOne() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        assertEquals("1,2,null,null,3,4,null,null,5,null,null", new SerializeAndDeserializeBinaryTree().serialize(root));
    }

    @Test
    public void testTwo() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        assertEquals(root, new SerializeAndDeserializeBinaryTree().deserialize("1,2,null,null,3,4,null,null,5,null,null"));
    }

}