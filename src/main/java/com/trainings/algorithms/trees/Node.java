package com.trainings.algorithms.trees;

import java.util.Objects;

public class Node {
    Node left, right;
    int data;

    Node(int data) {
        this.data = data;
        left = right = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return data == node.data && Objects.equals(left, node.left) && Objects.equals(right, node.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right, data);
    }

    @Override
    public String toString() {
        return "Node [left=" + left + ", right=" + right + ", data=" + data + "]";
    }
}
