package com.trainings.algorithms.trees;

public class BinarySearchTreeInsertion {

    public static Node insert(Node root,int data) {
        if(root == null) {
            return null;
        }
        insertRecursive(root, data);

        return root;
    }

    private static void insertRecursive(Node node, int data) {
        if(data <= node.data) {
            if(node.left != null) {
                insertRecursive(node.left, data);
            } else {
                node.left = new Node(data);
            }
        } else {
            if(node.right != null) {
                insertRecursive(node.right, data);
            } else {
                node.right = new Node(data);
            }
        }
    }
}
