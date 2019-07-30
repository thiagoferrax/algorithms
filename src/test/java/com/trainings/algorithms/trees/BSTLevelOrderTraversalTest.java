package com.trainings.algorithms.trees;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class BSTLevelOrderTraversalTest {

	@Test
	void whenRootIsNullShouldReturnNull() {
		Node root = null;
		Assert.assertNull(BSTLevelOrderTraversal.getLevelOrder(root));
	}
	
	@Test
	void whenRootIsNotNullShouldReturnAnStringWithCorrectNodeOrder() {
		Node root = new Node(10);
		root.left  = new Node(8);
		root.right = new Node(12);
		
		Assert.assertEquals("10 8 12", BSTLevelOrderTraversal.getLevelOrder(root));
	}

}
