package com.trainings.algorithms.trees;

public class TreeHeightOfABinaryTree {
    public static int height(Node root) {
        //The Height of binary tree with single node is taken as zero.
        if(root == null || (root.left == null && root.right == null)) {
            return 0;
        }

        return height(root, 0);
    }

    private static int height(Node node, int height) {
        int maxHeight = height;
        if(node.left != null) {
            maxHeight = Math.max(maxHeight, height(node.left, height + 1));
        }
        if(node.right != null) {
            maxHeight = Math.max(maxHeight, height(node.right, height + 1));
        }

        return maxHeight;
    }
}
