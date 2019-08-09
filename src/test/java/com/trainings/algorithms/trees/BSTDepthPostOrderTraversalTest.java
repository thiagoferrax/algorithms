package com.trainings.algorithms.trees;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class BSTDepthPostOrderTraversalTest {

	@Test
	void test() {
		Node root = new Node(10);
		root.left = new Node(8);
		root.right = new Node(14);
		root.right.left = new Node(11);
		root.right.left.right = new Node(12);
		
		BSTDepthPostOrderTraversal postOrderTraversal = new BSTDepthPostOrderTraversal();	
		Assert.assertArrayEquals(new Integer[] {8, 12, 11, 14, 10}, postOrderTraversal.traversal(root));
	}

}
