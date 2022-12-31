package com.trainings.algorithms.trees;

public class Node {
    Node left, right;
    int data;

    Node(int data) {
        this.data = data;
        left = right = null;
    }

    @Override
    public String toString() {
        return "Node [left=" + left + ", right=" + right + ", data=" + data + "]";
    }
}
