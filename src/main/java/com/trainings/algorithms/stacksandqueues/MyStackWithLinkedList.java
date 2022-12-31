package com.trainings.algorithms.stacksandqueues;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Implementing a Stack using LinkedList.
 * https://www.udemy.com/master-the-coding-interview-data-structures-algorithms/learn/lecture/12333106#overview
 */
public class MyStackWithLinkedList<T> {

    LinkedList<T> linkedList;

    public MyStackWithLinkedList() {
        this.linkedList = new LinkedList<>();
    }

    public void push(T value) {
        this.linkedList.add(value);
    }

    public int length() {
        return linkedList.size();
    }

    public T pop() {
        T removed;
        try {
            removed = linkedList.removeLast();
        } catch (NoSuchElementException e) {
            removed = null;
        }

        return removed;
    }

    public T peek() {
        return linkedList.getLast();
    }

}
