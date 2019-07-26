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

	private class Node<U> {
		private U value;
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
			if (value.compareTo(root.value) == 0) {
				this.root = null;
				length--;
				return true;
			}
			return false;
		}

		Node<T> parentNode = null;
		Node<T> foundNode = null;
		Node<T> node = root;
		while (node != null) {
			if (value.compareTo(node.value) == 0) {
				foundNode = node;
				break;
			} else if (value.compareTo(node.value) < 0) {
				node = node.left;
				parentNode = node;
			} else {
				node = node.right;
				parentNode = node;
			}
		}

		if (foundNode == null) {
			return false;
		}

		if (foundNode.left == null && foundNode.right == null) {
			if (foundNode.value.compareTo(parentNode.value) <= 0) {
				parentNode.left = null;
			} else {
				parentNode.right = null;
			}
			length--;
			return true;
		} else {

		}

		return false;
	}
}
