package com.trainings.algorithms.stacksandqueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * A palindrome is a word, phrase, number, or other sequence of characters which
 * reads the same backwards and forwards.
 * https://www.hackerrank.com/challenges/30-queues-stacks/problem
 */
public class Palindrome {
    private final Deque<Character> stack;
    private final Deque<Character> queue;

    public Palindrome() {
        stack = new ArrayDeque<Character>();
        queue = new ArrayDeque<Character>();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();

        boolean isPalindrome = isPalindrome(input);

        // Finally, print whether string s is palindrome or not.
        System.out.println("The word, " + input + ", is " + ((!isPalindrome) ? "not a palindrome." : "a palindrome."));
    }

    public static boolean isPalindrome(String input) {
        // Convert input String to an array of characters:
        char[] s = input.toLowerCase().toCharArray();

        // Create a Solution object:
        Palindrome p = new Palindrome();

        // Enqueue/Push all chars to their respective data structures:
        for (char c : s) {
            p.pushCharacter(c);
            p.enqueueCharacter(c);
        }

        // Pop/Dequeue the chars at the head of both data structures and compare them:
        boolean isPalindrome = true;
        for (int i = 0; i < s.length / 2; i++) {
            if (p.popCharacter() != p.dequeueCharacter()) {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }

    private Object popCharacter() {
        return stack.pollLast();
    }

    private Object dequeueCharacter() {
        return queue.pollFirst();
    }

    private void enqueueCharacter(char c) {
        queue.push(c);
    }

    private void pushCharacter(char c) {
        stack.push(c);
    }
}
