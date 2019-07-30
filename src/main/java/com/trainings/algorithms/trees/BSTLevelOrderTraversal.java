package com.trainings.algorithms.trees;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * A level-order traversal, also known as a breadth-first search, visits each
 * level of a tree's nodes from left to right, top to bottom. You are given a
 * pointer, root, pointing to the root of a binary search tree.
 * https://www.hackerrank.com/challenges/30-binary-trees/problem
 */
class BSTLevelOrderTraversal {

	static void levelOrder(Node root) {
		System.out.println(getLevelOrder(root));
	}

	public static String getLevelOrder(Node root) {
		if (root == null) {
			return null;
		}

		Deque<Node> queue = new ArrayDeque<>();

		queue.push(root);

		StringBuilder builder = new StringBuilder();
		
		while (queue.peek() != null) {
			Node first = queue.poll();

			if (first.left != null) {
				queue.add(first.left);
			}

			if (first.right != null) {
				queue.add(first.right);
			}
			
			if(builder.length() > 0) {
				builder.append(" ");
			}	
			builder.append(first.data);
		}

		return builder.toString();
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

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		Node root = null;
		while (T-- > 0) {
			int data = sc.nextInt();
			root = insert(root, data);
		}
		levelOrder(root);

		sc.close();
	}
}