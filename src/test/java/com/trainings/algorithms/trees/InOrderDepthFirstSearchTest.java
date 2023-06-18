package com.trainings.algorithms.trees;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class InOrderDepthFirstSearchTest {
    @Test
    public void example1(){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.left.left.left = new TreeNode(1);

        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        assertEquals(List.of(1, 2, 3, 4, 5, 6, 7, 8), new InOrderDepthFirstSearch().traverse(root));
    }
}