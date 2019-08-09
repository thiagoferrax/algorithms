package com.trainings.algorithms.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Traversal of a binary search tree in pre order.
 * https://www.udemy.com/master-the-coding-interview-data-structures-algorithms/learn/lecture/12431196#overview
 */
public class BSTDepthPreOrderTraversal {

	public static Integer[] traversal(Node root) {
		List<Integer> data = new ArrayList<>();
		Deque<Node> stack = new ArrayDeque<>();
		
		stack.push(root);
		while(!stack.isEmpty()) {
			Node node = stack.pop();
			data.add(node.data);
			
			if(node.right != null) {
				stack.push(node.right);
			}
			
			if(node.left != null) {
				stack.push(node.left);
			}
		}	
		
		return data.stream().toArray(Integer[]::new);
	}

}
