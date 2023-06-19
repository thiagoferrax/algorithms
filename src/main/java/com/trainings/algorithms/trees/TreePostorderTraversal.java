package com.trainings.algorithms.trees;

public class TreePostorderTraversal {
    public static String postOrder(Node root) {
        if(root == null) {
            return null;
        }

        // Depth Fist Search / Traversal
        StringBuilder builder = new StringBuilder();
        postOrder(root, builder);

        return builder.toString();
    }

    private static void postOrder(Node node, StringBuilder builder) {

        if(node.left != null) {
            postOrder(node.left, builder);
        }
        if(node.right != null) {
            postOrder(node.right, builder);
        }
        if(!builder.isEmpty()) {
            builder.append(" ");
        }
        builder.append(node.data);
    }
}
