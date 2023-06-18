package com.trainings.algorithms.trees;

import java.util.ArrayList;
import java.util.List;

public class PreOrderDepthFirstSearch {

    public List<Integer> traverse(TreeNode root) {
        if(root == null) {
            return null;
        }
        List<Integer> preOrderDFSTraversed = new ArrayList<>();
        traverse(root, preOrderDFSTraversed);
        return preOrderDFSTraversed;
    }

    private void traverse(TreeNode node, List<Integer> preOrderDFSTraversed) {
        preOrderDFSTraversed.add(node.val);
        if(node.left != null) {
            traverse(node.left, preOrderDFSTraversed);
        }
        if(node.right != null) traverse(node.right, preOrderDFSTraversed);
    }
}
