package com.trainings.algorithms.arrays;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

/**
 * <a href="https://leetcode.com/problems/maximum-value-of-k-coins-from-piles/">maximum-value-of-k-coins-from-piles</a>
 */
public class MaximumValueOfKCoinsFromPilesTest extends TestCase {
    @Test
    public void testOne(){
        assertEquals(101, new MaximumValueOfKCoinsFromPiles().maxValueOfCoins(List.of(List.of(1,100,3),List.of(7,8,9)), 2));
    }

    @Test
    public void testTwo(){
        assertEquals(706, new MaximumValueOfKCoinsFromPiles().maxValueOfCoins(List.of(List.of(100),List.of(100),List.of(100),List.of(100),List.of(100),List.of(100),List.of(1,1,1,1,1,1,700)), 7));
    }

    @Test
    public void testThree(){
        assertEquals(421, new MaximumValueOfKCoinsFromPiles().maxValueOfCoins(List.of(List.of(48,14,23,38,33,79,3,52,73,58,49,23,74,44,69,76,83,41,46,32,28)), 10));
    }

    @Test
    public void testFour(){
        assertEquals(494, new MaximumValueOfKCoinsFromPiles().maxValueOfCoins(List.of(List.of(37,88), List.of(51,64,65,20,95,30,26), List.of(9,62,20), List.of(44)), 9));
    }

}