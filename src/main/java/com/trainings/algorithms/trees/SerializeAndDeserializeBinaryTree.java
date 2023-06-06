package com.trainings.algorithms.trees;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/serialize-and-deserialize-binary-tree/">serialize-and-deserialize-binary-tree</a>
 */
public class SerializeAndDeserializeBinaryTree {

    private static String serializeTree(String tree, Queue<TreeNode> queue) {
        if (queue.isEmpty()) {
            return tree;
        }

        TreeNode node = queue.poll();

        boolean isNotNull = node != null && node.val != Integer.MIN_VALUE;

        if (!tree.isEmpty()) {
            tree += ",";
        }
        tree += isNotNull ? node.val : "null";

        if (isNotNull) {
            queue.add(node.left != null ? node.left : new TreeNode(Integer.MIN_VALUE));
            queue.add(node.right != null ? node.right : new TreeNode(Integer.MIN_VALUE));
        }

        return serializeTree(tree, queue);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String tree = "";
        if (root == null) {
            return tree;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        tree = serializeTree("", queue);

        String[] nodes = tree.split(",");
        int i = nodes.length - 1;
        for (; i >= 0; i--) {
            if (!"null".equals(nodes[i])) break;
        }

        return Arrays.toString(Arrays.copyOf(nodes, i + 1));
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        TreeNode root = null;

        if (data != null && !data.isEmpty() && !"[]".equals(data)) {
            data = data.replace("[", "").replace("]", "");
            boolean onlyOneElement = !data.contains(",");
            if (onlyOneElement) {
                return new TreeNode(Integer.parseInt(data.trim()));
            } else {
                String[] nodes = data.split(",");

                Queue<TreeNode> queue = new ArrayDeque<>();
                root = new TreeNode(Integer.parseInt(nodes[0].trim()));
                queue.add(root);

                createMagicTree(queue, nodes, 0);
            }
        }

        return root;
    }

    private void createMagicTree(Queue<TreeNode> queue, String[] nodes, int i) {
        TreeNode node = queue.poll();

        String value;
        TreeNode left = null, right = null;

        if (node != null) {
            if (i + 1 < nodes.length) {
                value = nodes[i + 1].trim();
                if (!"null".equals(value)) {
                    left = new TreeNode(Integer.parseInt(value));
                    queue.add(left);
                }
            }
            node.left = left;

            if (i + 2 < nodes.length) {
                value = nodes[i + 2].trim();
                if (!"null".equals(value)) {
                    right = new TreeNode(Integer.parseInt(value));
                    queue.add(right);
                }
            }
            node.right = right;

            createMagicTree(queue, nodes, i + 2);
        }
    }
}
