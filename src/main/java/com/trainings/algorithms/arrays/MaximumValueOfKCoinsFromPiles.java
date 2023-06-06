package com.trainings.algorithms.arrays;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/maximum-value-of-k-coins-from-piles/">maximum-value-of-k-coins-from-piles</a>
 */
public class MaximumValueOfKCoinsFromPiles {

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {

        // 1. Create a list to add all elements from position 0 to k-1 on all piles.
        List<Coin> firstKCoinsAllPiles = new ArrayList<>();

        // 2. Create a hashmap that will keep the value of the element and will point to the pile index and the position it has in that specific pile.
        //Map<Integer, Map<Integer, Integer>> valuePileIndexMap = new HashMap<>();

        for (int p = 0; p < piles.size(); p++) {
            List<Integer> pile = piles.get(p);
            for (int i = 0; i < pile.size() && i < k; i++) {
                firstKCoinsAllPiles.add(new Coin(pile.get(i), p, i));
            }
        }

        //3. Then order the elements of that initial list in descending order.
        firstKCoinsAllPiles.sort(Comparator.comparingInt(o -> o.index));
        firstKCoinsAllPiles.sort((o1, o2) -> o2.value - o1.value);

        System.out.println(firstKCoinsAllPiles);

        List<List<Coin>> possibleCoins = new ArrayList<>();
        List<Coin> coins = new ArrayList<>();

        int count = 0;
        Coin coin;
        Set<Coin> needToHave = null;

        for (int i = 0; i < firstKCoinsAllPiles.size() - 1; i++) {
            for (int j = i + 1; j < firstKCoinsAllPiles.size() && count < k; j++) {
                if (count == 0) {
                    coins = new ArrayList<>();
                    coin = firstKCoinsAllPiles.get(i);
                    coins.add(coin);
                    count++;

                    needToHave = new HashSet<>();
                    Coin coinOnTop = getCoinOnTop(coin);
                    if (coinOnTop != null) {
                        needToHave.add(coinOnTop);
                    }
                }

                coin = firstKCoinsAllPiles.get(j);
                coins.add(coin);
                needToHave.remove(coin);
                count++;

                Coin coinOnTop = getCoinOnTop(coin);
                if (coinOnTop != null && !coins.contains(coinOnTop)) {
                    needToHave.add(coinOnTop);
                }

                if (count == k) {
                    possibleCoins.add(coins);

                    if (needToHave.isEmpty()) {
                        int sum = 0;
                        for (Coin sCoin : coins) {
                            sum += sCoin.value;
                        }
                        return sum;
                    }
                    count = 0;
                }
            }
        }

        System.out.println(possibleCoins);
        /*
         2. Create a hashmap that will keep the value of the element and will point to the pile index and the position it has in that specific pile.
         3. Then order the elements of that initial list in descending order.
         4. Then now iterate to that sorted list and try to get the elements from the lists in the way to have the maximum of big elements according to the queue constraints and keep track of the maximum sum on them;
        */

        //piles = [[1,100,3],[7,8,9]], k = 2
        // 1, 100, 7, 8
        // hashmap = [
        //      1 => hashmap [ pile 0 => index 0]
        //      100 => hashmap [ pile 0 => index 1]
        //      7 => hashmap [ pile 1 => index 0]
        //      8 => hashmap [ pile 1 => index 1]
        // ]
        // 100, 8, 7, 1
        // [100, 8], [100, 7], [100, 1], [8, 7], [8, 1], [7, 1]
        // [100, 8] => [p0,i1], [p1,i1] NO
        // [100, 7] => [p0,i1], [p1,i0] NO
        // [100, 1] => [p0,i1], [p0,i0] YES break!

        // Iterate through the found array and sum their values and return it as a result.

        return 0;
    }

    private Coin getCoinOnTop(Coin coin) {
        return coin.index > 0 ? new Coin(coin.pile, coin.index - 1) : null;
    }

    private static class Coin {
        Integer value;
        int pile;
        int index;

        public Coin(Integer value, Integer pile, Integer index) {
            this.value = value;
            this.pile = pile;
            this.index = index;
        }

        public Coin(Integer pile, Integer index) {
            this(null, pile, index);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coin coin = (Coin) o;
            return pile == coin.pile && index == coin.index;
        }

        @Override
        public int hashCode() {
            return Objects.hash(pile, index);
        }

        @Override
        public String toString() {
            return "{" + value +
                    ", " + pile +
                    ", " + index +
                    '}';
        }
    }
}
