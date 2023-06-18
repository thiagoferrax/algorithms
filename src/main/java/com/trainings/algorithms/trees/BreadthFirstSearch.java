package com.trainings.algorithms.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {
    public List<Integer> traverse(TreeNode root) {
        if(root == null) {
            return null;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        List<Integer> bsfTraversed = new ArrayList<>();
        traverse(queue, bsfTraversed);

        return bsfTraversed;
    }

    private void traverse(Queue<TreeNode> queue, List<Integer> bsfTraversed) {
        if(!queue.isEmpty()) {
            TreeNode current = queue.poll();
            bsfTraversed.add(current.val);

            if(current.left != null) queue.add(current.left);
            if(current.right != null) queue.add(current.right);

            traverse(queue, bsfTraversed);
        }
    }
}
