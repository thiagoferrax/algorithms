package com.trainings.algorithms.trees;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


class BinarySearchTreesTest {

	@Test
	void whenTreeHasOnlyOneNodeReturnZero() {
		Node root = new Node(10);
		Assert.assertEquals(0, BinarySearchTrees.getHeight(root));
	}
	
	@Test
	void whenTreeHasOnlyRootAndLeftAndOrRightNodeReturnTwo() {
		Node root = new Node(10);
		root.left = new Node(8);
		root.right = new Node(12);
		
		Assert.assertEquals(1, BinarySearchTrees.getHeight(root));
	}
	
	@Test
	void whenTreeHasHeightTree() {
		Node root = new Node(10);
		root.left = new Node(8);
		root.right = new Node(12);
		root.right.left = new Node(11);
		
		Assert.assertEquals(2, BinarySearchTrees.getHeight(root));
	}
	
	@Test
	void whenTreeHasHeightFour() {
		Node root = new Node(10);
		root.left = new Node(8);
		root.right = new Node(14);
		root.right.left = new Node(11);
		root.right.left.right = new Node(12);
		
		Assert.assertEquals(3, BinarySearchTrees.getHeight(root));
	}

}
