package com.trainings.algorithms.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * The function is expected to return an INTEGER_ARRAY. The function accepts
 * following parameters: 1. INTEGER n 2. 2D_INTEGER_ARRAY queries.
 * https://www.hackerrank.com/challenges/dynamic-array/problem
 */
class DynamicArray {

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        // Write your code here
        List<List<Integer>> seqList = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            seqList.add(new ArrayList<Integer>());
        }

        int lastAnswer = 0;

        List<Integer> aSolution = new ArrayList<Integer>();
        for (List<Integer> query : queries) {
            int type = query.get(0);
            int x = query.get(1);
            int y = query.get(2);

            int seq = (x ^ lastAnswer) % n;
            List<Integer> sequence = seqList.get(seq);

            if (type == 1) {
                sequence.add(y);
            } else {
                int size = sequence.size();
                if (y % size < size) {
                    lastAnswer = sequence.get(y % size);
                }
                aSolution.add(lastAnswer);
            }

        }

        return aSolution;

    }

}