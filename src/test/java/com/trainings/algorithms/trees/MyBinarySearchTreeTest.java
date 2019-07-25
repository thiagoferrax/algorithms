package com.trainings.algorithms.trees;

import java.util.Comparator;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class MyBinarySearchTreeTest {

	@Test
	void whenInsertingANodeInAnEmptyTreeItWillPutItAsRootNode() {
		
		Comparator<Integer> comparator = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		};
		
		MyBinarySearchTree<Integer> tree = new MyBinarySearchTree<Integer>(comparator);
		tree.insert(10);
		
		Assert.assertEquals(1, tree.length());
		
	}

}
