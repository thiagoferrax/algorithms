package com.trainings.algorithms.trees;

public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        if(root==null || (root.left == null && root.right == null)) {
            return true;
        }
        return isValidBSTRecursive(root);
    }

    private static boolean isValidBSTRecursive(TreeNode node) {
        if(node == null) {
            return true;
        }
        if(node.left != null) {
            boolean leftChildBiggerThanParent = node.left.val >= node.val;
            boolean rightGrandChildBiggerThanParent = node.left.right !=null && node.left.right.val >= node.val;
            if(leftChildBiggerThanParent || rightGrandChildBiggerThanParent) {
                return false;
            }
        }
        if(node.right != null) {
            boolean rightChildSmallerThanParent = node.right.val <= node.val;
            boolean leftGrandChildSmallerThanParent = node.right.left !=null && node.right.left.val <= node.val;
            boolean leftGrandChildSmallerThanRoot = node.right.left !=null && node.right.left.val <= node.val;
            if(rightChildSmallerThanParent || leftGrandChildSmallerThanParent) {
                return false;
            }
        }

        return isValidBSTRecursive(node.left) && isValidBSTRecursive(node.right);
    }
}
