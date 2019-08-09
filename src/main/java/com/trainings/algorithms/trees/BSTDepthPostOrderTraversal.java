package com.trainings.algorithms.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Traversal of a binary search tree in post-order.
 * https://www.udemy.com/master-the-coding-interview-data-structures-algorithms/learn/lecture/12431196#overview
 */
public class BSTDepthPostOrderTraversal {

	class NodeDecorator {
		private Node node;

		private boolean visited;

		public NodeDecorator(Node node) {
			this.node = node;
		}

		public boolean isVisited() {
			return this.visited;
		}

		public void setVisited(boolean visited) {
			this.visited = visited;
		}

		public NodeDecorator getLeft() {
			return node.left != null ? new NodeDecorator(node.left) : null;
		}

		public NodeDecorator getRight() {
			return node.right != null ? new NodeDecorator(node.right) : null;
		}

		public Integer getData() {
			return node.data;
		}

		@Override
		public String toString() {
			return "NodeDecorator [node=" + node.data + ", visited=" + visited + "]";
		}
	}

	public Integer[] traversal(Node root) {
		List<Integer> data = new ArrayList<>();
		Deque<NodeDecorator> stack = new ArrayDeque<>();

		stack.push(new NodeDecorator(root));
		while (!stack.isEmpty()) {
			NodeDecorator node = stack.peek();

			if (node.isVisited() || (node.getLeft() == null && node.getRight() == null)) {
				NodeDecorator element = stack.pop();
				data.add(element.getData());
			} else {
				if (node.getRight() != null) {
					stack.push(node.getRight());
				}

				if (node.getLeft() != null) {
					stack.push(node.getLeft());
				}

				node.setVisited(true);
			}

		}

		return data.stream().toArray(Integer[]::new);
	}

}
