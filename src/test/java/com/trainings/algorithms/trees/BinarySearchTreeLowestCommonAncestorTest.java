package com.trainings.algorithms.trees;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeLowestCommonAncestorTest {

    @Ignore
    @Test
    public void example1(){
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        root.right.right.right = new Node(6);

        Node lcaNode = root.right;

        assertEquals(lcaNode, BinarySearchTreeLowestCommonAncestor.lca(root, 4, 6));
    }
    @Test
    public void example2(){
        Node root = new Node(4);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right = new Node(7);
        root.right.left = new Node(6);

        Node lcaNode = root;

        assertEquals(lcaNode, BinarySearchTreeLowestCommonAncestor.lca(root, 1, 7));
    }
    @Test
    public void example3(){
        Node root = new Node(8);
        root.left = new Node(4);
        root.left.left = new Node(1);
        root.left.left.right = new Node(2);
        root.left.left.right.right = new Node(3);
        root.left.right = new Node(6);
        root.left.right.left = new Node(5);

        root.right = new Node(9);

        Node lcaNode =  root.left.left ;

        assertEquals(lcaNode, BinarySearchTreeLowestCommonAncestor.lca(root, 1, 2));
    }

}