package com.trainings.algorithms.trees;

public class CountGoodNodesInBinaryTree {
    public int goodNodes(TreeNode root) {
        // EDGE CASE: root element null, return zero, root node is not null, it is the only element in the tree: return 1
        if(root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return  1;
        }
        // create a variable that will keeep maximun value before the current node.
        return calculateNumberOfGoodNodes(root, Integer.MIN_VALUE, 0);
    }

    private int calculateNumberOfGoodNodes(TreeNode node, int maxValueBeforeNode, int count) {
        int counter = count;
        if(node != null) {
            // There are no nodes with a value greater than current node => GOOD
            if(maxValueBeforeNode <= node.val) {
                count++;
            }
            int left = calculateNumberOfGoodNodes(node.left, Math.max(maxValueBeforeNode, node.val), count);
            int right = calculateNumberOfGoodNodes(node.right, Math.max(maxValueBeforeNode, node.val), left);
            counter = Math.max(left, right);
        }
        return counter;
    }

}
