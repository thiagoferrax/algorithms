package com.trainings.algorithms.trees;

import java.util.Comparator;

public class MyBinarySearchTree<T> {
	private Node<T> root;
	private int length;
	private Comparator<T> comparator;

	public MyBinarySearchTree(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	public void insert(T value) {
		if(this.root == null) {
			this.root = new Node<T>(value);
			this.length++;
		} else {
			insert(this.root, value);
		}
	}

	private void insert(MyBinarySearchTree<T>.Node<T> node, T value) {
		if (comparator.compare(value, node.value) <= 0) {
			if(node.left == null) {
				node.left = new Node<T>(value);
				this.length++;
			} else if () {
				
			}else {
				insert(node.left, value);
			}
		} else {
			if(node.right == null) {
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
}
