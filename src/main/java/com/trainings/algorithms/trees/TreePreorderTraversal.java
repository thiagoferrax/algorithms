package com.trainings.algorithms.trees;

public class TreePreorderTraversal {
    public static String preOrder(Node root) {
        if(root == null) {
            return null;
        }

        // Depth Fist Search / Traversal
        StringBuilder builder = new StringBuilder();
        preOrder(root, builder);

        return builder.toString();
    }

    private static void preOrder(Node node, StringBuilder builder) {
        if(!builder.isEmpty()) {
            builder.append(" ");
        }
        builder.append(node.data);
        if(node.left != null) {
            preOrder(node.left, builder);
        }
        if(node.right != null) {
            preOrder(node.right, builder);
        }
    }
}
