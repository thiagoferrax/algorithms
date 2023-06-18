package com.trainings.algorithms.trees;

import java.util.ArrayList;
import java.util.List;
public class InOrderDepthFirstSearch {

    public List<Integer> traverse(TreeNode root) {
        if(root == null) {
            return null;
        }
        List<Integer> inOrderDFSTraversed = new ArrayList<>();
        traverse(root, inOrderDFSTraversed);
        return inOrderDFSTraversed;
    }

    private void traverse(TreeNode node, List<Integer> inOrderDFSTraversed) {
        if(node.left != null) {
            traverse(node.left, inOrderDFSTraversed);
        }
        inOrderDFSTraversed.add(node.val);
        if(node.right != null) traverse(node.right, inOrderDFSTraversed);
    }
}
