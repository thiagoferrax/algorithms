package com.trainings.algorithms.trees;

public class MyBinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;
    private int length;

    public void insert(T value) {
        if (this.root == null) {
            this.root = new Node<T>(value);
            this.length++;
        } else {
            insert(this.root, value);
        }
    }

    @SuppressWarnings("unchecked")
    public void insert(T... values) {
        for (int i = 0; i < values.length; i++) {
            insert(values[i]);
        }
    }

    private void insert(MyBinarySearchTree<T>.Node<T> node, T value) {
        if (value.compareTo(node.value) <= 0) {
            if (node.left == null) {
                node.left = new Node<T>(value);
                this.length++;
            } else {
                insert(node.left, value);
            }
        } else {
            if (node.right == null) {
                node.right = new Node<T>(value);
                this.length++;
            } else {
                insert(node.right, value);
            }
        }
    }

    public void print() {
        System.out.println(this.root);
    }

    public int length() {
        return length;
    }

    public Node<T> search(T value) {
        if (value == null || root == null) {
            return null;
        }

        Node<T> node = root;
        while (node != null) {
            if (value.compareTo(node.value) == 0) {
                return node;
            } else if (value.compareTo(node.value) < 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        return null;
    }

    public boolean remove(T value) {
        if (value == null || root == null) {
            return false;
        }

        if (length == 1) {
            if (root.value.compareTo(value) == 0) {
                root = null;
                length--;
                return true;
            }
            return false;
        }

        Node<T> currentNode = root, parentNode = null;
        while (currentNode != null) {
            if (value.compareTo(currentNode.value) == 0) {

                if (currentNode.left == null) {
                    updateTree(parentNode, currentNode, currentNode.right);
                } else if (currentNode.right == null) {
                    updateTree(parentNode, currentNode, currentNode.left);
                } else if (currentNode.right.left != null) {
                    updateTree(parentNode, currentNode, currentNode.right.left);
                } else {
                    updateTree(parentNode, currentNode, currentNode.right);
                    updateTree(parentNode.left, currentNode, currentNode.left);
                }
                length--;
                return true;

            } else if (value.compareTo(currentNode.value) < 0) {
                parentNode = currentNode;
                currentNode = currentNode.left;
            } else {
                parentNode = currentNode;
                currentNode = currentNode.right;
            }
        }

        return false;
    }

    private void updateTree(Node<T> parentNode, Node<T> selectedNode, MyBinarySearchTree<T>.Node<T> side) {
        if (selectedNode.value.compareTo(parentNode.value) <= 0) {
            parentNode.left = side;
        } else {
            parentNode.right = side;
        }
    }

    private class Node<U> {
        private final U value;
        private Node<U> left;
        private Node<U> right;

        public Node(U value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node [value=" + value + ", left=" + left + ", right=" + right + "]";
        }
    }
}
