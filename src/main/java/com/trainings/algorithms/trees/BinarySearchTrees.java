package com.trainings.algorithms.trees;

import java.util.Scanner;

/**
 * Find the height of a BST. The height of a binary search tree is the number of
 * edges between the tree's root and its furthest leaf.
 * https://www.hackerrank.com/challenges/30-binary-search-trees/problem
 */
class BinarySearchTrees {

    public static int getHeight(Node root) {
        return getMaxPath(root, 0) - 1;
    }

    private static int getMaxPath(Node node, int maxHeight) {
        if (node != null) {
            int leftMaxHeight = getMaxPath(node.left, maxHeight + 1);
            int rightMaxHeight = getMaxPath(node.right, maxHeight + 1);

            return Math.max(leftMaxHeight, rightMaxHeight);
        }

        return maxHeight;
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        Node root = null;
        while (T-- > 0) {
            int data = sc.nextInt();
            root = insert(root, data);
        }
        int height = getHeight(root);
        System.out.println(height);

        sc.close();
    }
}