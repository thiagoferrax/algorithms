package com.trainings.algorithms.trees;

import java.util.Comparator;

public class MyBinarySearchTree<T> {
	private Node<T> root;
	private int lenght;
	private Comparator<T> comparator;

	public MyBinarySearchTree(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	public void insert(T value) {
		insert(this.root, value);
	}

	private void insert(MyBinarySearchTree<T>.Node<T> node, T value) {
		if (node == null) {
			node = new Node<T>(value);
			lenght++;
		} else if (comparator.compare(value, node.value) <= 0) {
			insert(node.left, value);
		} else {
			insert(node.right, value);
		}
	}

	public void print() {
		System.out.println(this.root);
	}
	
	public int length() {
		return lenght;
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
}
