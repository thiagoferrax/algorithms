package com.trainings.algorithms.trees;

import org.junit.Assert;
import org.junit.Test;


class MyObject implements Comparable<MyObject> {
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

public class MyBinarySearchTreeTest {

    @Test
    public void whenInsertingANodeInAnEmptyTreeItWillPutItAsRootNode() {

        MyBinarySearchTree<Integer> tree = new MyBinarySearchTree<Integer>();
        tree.insert(10);

        Assert.assertEquals(1, tree.length());
    }

    @Test
    public void whenInsertingNodesIncreaseTheTree() {

        MyBinarySearchTree<MyObject> tree = new MyBinarySearchTree<MyObject>();
        tree.insert(new MyObject(10));
        tree.insert(new MyObject(12));
        tree.insert(new MyObject(11));
        tree.insert(new MyObject(6));
        tree.insert(new MyObject(9));

        Assert.assertEquals(5, tree.length());
    }

    @Test
    public void whenSearchingAnExistingElementShouldReturnTrue() {
        MyBinarySearchTree<MyObject> tree = new MyBinarySearchTree<MyObject>();
        tree.insert(new MyObject(10));
        tree.insert(new MyObject(12));
        tree.insert(new MyObject(11));
        tree.insert(new MyObject(6));
        tree.insert(new MyObject(9));

        Assert.assertNotNull(tree.search(new MyObject(6)));
    }

    @Test
    public void whenRemovingAnExistingElementInATreeThatOnlyContainsTheRoot() {
        MyBinarySearchTree<Integer> tree = new MyBinarySearchTree<Integer>();
        tree.insert(10);

        Assert.assertTrue(tree.remove(10));

        Assert.assertEquals(0, tree.length());
    }

    @Test
    public void whenRemovingAnExistingElementWithNoChildreenInATreeWithElements() {
        MyBinarySearchTree<Integer> tree = new MyBinarySearchTree<Integer>();
        tree.insert(10, 7, 12);

        tree.print();

        Assert.assertTrue(tree.remove(12));

        tree.print();

        Assert.assertEquals(2, tree.length());
    }

    @Test
    public void whenRemovingAnExistingElementWithNoChildreenInATreeWithElements_OnlyRightNode() {
        MyBinarySearchTree<Integer> tree = new MyBinarySearchTree<Integer>();
        tree.insert(10, 7, 12, 14);

        tree.print();

        Assert.assertTrue(tree.remove(12));

        tree.print();

        Assert.assertEquals(3, tree.length());
    }

    @Test
    public void whenRemovingAnExistingElementWithNoChildreenInATreeWithElements_OnlyLeftNode() {
        MyBinarySearchTree<Integer> tree = new MyBinarySearchTree<Integer>();
        tree.insert(10, 7, 12, 11);

        tree.print();

        Assert.assertTrue(tree.remove(11));

        tree.print();

        Assert.assertEquals(3, tree.length());
    }


    @Test
    public void whenRemovingAnExistingElementWithNoChildreenInATreeWithElements_WithLeftAndRightNodes() {
        MyBinarySearchTree<Integer> tree = new MyBinarySearchTree<Integer>();
        tree.insert(10, 7, 13, 12, 15, 11);

        tree.print();

        Assert.assertTrue(tree.remove(13));

        tree.print();

        Assert.assertEquals(5, tree.length());
    }

    @Test
    public void whenTryingToRemoveANonExistingNode() {
        MyBinarySearchTree<Integer> tree = new MyBinarySearchTree<Integer>();
        tree.insert(10, 7, 13, 12, 15, 11);

        Assert.assertFalse(tree.remove(1));
    }
}
