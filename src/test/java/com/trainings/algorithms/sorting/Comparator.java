package com.trainings.algorithms.sorting;

import java.util.Arrays;
import java.util.Scanner;

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Player [name=" + name + ", score=" + score + "]";
    }


}

class Checker implements java.util.Comparator<Player> {
    // complete this method
    public int compare(Player a, Player b) {
        int comparison = Integer.valueOf(b.score).compareTo(a.score);

        if (comparison == 0) {
            comparison = a.name.compareTo(b.name);
        }

        return comparison;
    }
}

/**
 * https://www.hackerrank.com/challenges/ctci-comparator-sorting
 * Create a comparator and use it to sort an array.
 */
public class Comparator {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for (int i = 0; i < n; i++) {
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for (int i = 0; i < player.length; i++) {
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}