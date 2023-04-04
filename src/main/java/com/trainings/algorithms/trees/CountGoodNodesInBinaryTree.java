package com.trainings.algorithms.trees;

public class CountGoodNodesInBinaryTree {
    public int goodNodes(TreeNode root) {
        return calculateNumberOfGoodNodes(root, Integer.MIN_VALUE, 0);
    }

    private int calculateNumberOfGoodNodes(TreeNode node, int maxValueBeforeNode, int count) {
        if(node != null) {
            if(maxValueBeforeNode <= node.val) {
                count++;
            }
            int left = count, right = count;

            if(node.left != null) {
                left = calculateNumberOfGoodNodes(node.left, Math.max(maxValueBeforeNode, node.val), count);
            }
            if(node.right != null) {
                right = calculateNumberOfGoodNodes(node.right, Math.max(maxValueBeforeNode, node.val), left);
            }

            count = Math.max(left, right);
        }
        return count;
    }

}
