package com.trainings.algorithms.trees;

import java.util.*;

public class CheckCompletenessOfABinaryTree {

    public boolean isCompleteTree(TreeNode root) {

            // 1. Read the tree and create an array

            Integer[] treeAsArray = tree2Array(root);

            // Check for null elements in the array to take decision about if it complete or not.

            // [1, 2, 3, 4, 5] TRUE
            // [1, 2, 3, 4, null, 5, 7] FALSE
            // [1, 2, 3, 4, 5, null, null] TRUE

            return isCompleteTree(treeAsArray);
    }

    private boolean isCompleteTree(Integer[] treeAsArray) {
        if(treeAsArray == null) {
            return false;
        } else if(Arrays.toString(treeAsArray).contains("null")) {
            boolean previousFoundNotNullElement = false;
            for (int i = treeAsArray.length - 1; i >= 0; i--) {
                if(treeAsArray[i] == null) {
                    if(previousFoundNotNullElement) {
                        return false;
                    }
                } else {
                    previousFoundNotNullElement = true;
                }
            }
        }

        return true;
    }

    private Integer[] tree2Array(TreeNode root) {
        List<Integer> tree = new ArrayList<>();

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        buildArray(tree, queue);

        return tree.toArray(Integer[]::new);
    }

    private static void buildArray(List<Integer> tree, LinkedList<TreeNode> queue) {
        TreeNode node = queue.poll();
        tree.add(node!=null?node.val:null);

        if(node!=null) {
            queue.add(node.left);
            queue.add(node.right);

            buildArray(tree, queue);
        }
    }
}
