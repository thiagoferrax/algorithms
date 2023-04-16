package com.trainings.algorithms.arrays;

import junit.framework.TestCase;
import org.junit.Test;
import java.util.List;

public class MaximumValueOfKCoinsFromPilesTest extends TestCase {
    @Test
    public void testOne(){
        assertEquals(101, new MaximumValueOfKCoinsFromPiles().maxValueOfCoins(List.of(List.of(1,100,3),List.of(7,8,9)), 2));
    }

    @Test
    public void testTwo(){
        assertEquals(706, new MaximumValueOfKCoinsFromPiles().maxValueOfCoins(List.of(List.of(100),List.of(100),List.of(100),List.of(100),List.of(100),List.of(100),List.of(1,1,1,1,1,1,700)), 7));
    }

}