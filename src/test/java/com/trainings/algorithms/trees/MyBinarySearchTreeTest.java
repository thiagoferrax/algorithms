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

		Assert.assertNotNull(tree.search(new MyObject(6)));
	}
	
	@Test
	void whenRemovingAnExistingElementInATreeThatOnlyContainsTheRoot() {
		MyBinarySearchTree<Integer> tree = new MyBinarySearchTree<Integer>();
		tree.insert(10);
		
		Assert.assertTrue(tree.remove(10));
		
		Assert.assertEquals(0, tree.length());
	}
	
	@Test
	void whenRemovingAnExistingElementWithNoChildreenInATreeWithElements() {
		MyBinarySearchTree<Integer> tree = new MyBinarySearchTree<Integer>();
		tree.insert(10);
		tree.insert(7);
		tree.insert(12);
		tree.print();
		
		Assert.assertTrue(tree.remove(12));
		
		tree.print();
		
		Assert.assertEquals(2, tree.length());
	}
}
