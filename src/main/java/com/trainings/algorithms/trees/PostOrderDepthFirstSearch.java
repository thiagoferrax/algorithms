package com.trainings.algorithms.trees;

import java.util.ArrayList;
import java.util.List;

public class PostOrderDepthFirstSearch {

    public List<Integer> traverse(TreeNode root) {
        if(root == null) {
            return null;
        }
        List<Integer> postOrderDFSTraversed = new ArrayList<>();
        traverse(root, postOrderDFSTraversed);
        return postOrderDFSTraversed;
    }

    private void traverse(TreeNode node, List<Integer> postOrderDFSTraversed) {
        if(node.left != null) {
            traverse(node.left, postOrderDFSTraversed);
        }
        if(node.right != null) traverse(node.right, postOrderDFSTraversed);
        postOrderDFSTraversed.add(node.val);
    }
}
