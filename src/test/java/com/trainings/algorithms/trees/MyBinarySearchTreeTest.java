package com.trainings.algorithms.trees;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class MyObject implements Comparable<MyObject>{
	public Integer value;

	public MyObject(Integer value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}

	@Override
	public int compareTo(MyObject o) {
		return this.value.compareTo(o.value);
	}
}

class MyBinarySearchTreeTest {

	@Test
	void whenInsertingANodeInAnEmptyTreeItWillPutItAsRootNode() {

		MyBinarySearchTree<Integer> tree = new MyBinarySearchTree<Integer>();
		tree.insert(10);

		Assert.assertEquals(1, tree.length());
	}
	
	@Test
	void whenInsertingNodesIncreaseTheTree() {

		MyBinarySearchTree<MyObject> tree = new MyBinarySearchTree<MyObject>();
		tree.insert(new MyObject(10));
		tree.insert(new MyObject(12));
		tree.insert(new MyObject(11));
		tree.insert(new MyObject(6));
		tree.insert(new MyObject(9));
		
		tree.print();

		Assert.assertEquals(5, tree.length());
	}
	
	@Test
	void whenSearchingAnExistingElementShouldReturnTrue() {
		MyBinarySearchTree<MyObject> tree = new MyBinarySearchTree<MyObject>();
		tree.insert(new MyObject(10));
		tree.insert(new MyObject(12));
		tree.insert(new MyObject(11));
		tree.insert(new MyObject(6));
		tree.insert(new MyObject(9));

		Assert.assertTrue(tree.search(new MyObject(6)));
	}
}
