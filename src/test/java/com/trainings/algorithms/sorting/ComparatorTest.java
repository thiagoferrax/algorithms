package com.trainings.algorithms.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ComparatorTest {

    @Test
    public void test() {
        Player amy = new Player("amy", 100);
        Player david = new Player("david", 100);
        Player heraldo = new Player("heraldo", 50);
        Player aakansha = new Player("aakansha", 75);
        Player aleksa = new Player("aleksa", 150);

        List<Player> players = new ArrayList<Player>();
        players.add(amy);
        players.add(david);
        players.add(heraldo);
        players.add(aakansha);
        players.add(aleksa);

        Collections.sort(players, new Checker());

        Assert.assertArrayEquals(Arrays.asList(aleksa, amy, david, aakansha, heraldo).toArray(), players.toArray());
    }

}
