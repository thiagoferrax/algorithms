package com.trainings.algorithms.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/all-paths-from-source-to-target/submissions/928095163/">ll-paths-from-source-to-target</a>
 */
public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> allPaths = new ArrayList<>();

        findAllPaths(graph, allPaths, "0", 0);

        return allPaths;
    }

    private static void findAllPaths(int[][] graph, List<List<Integer>> allPaths, String csvList,  int i) {
        if(i == graph.length-1) {
            allPaths.add(Arrays.stream(csvList.split(",")).map(Integer::parseInt).toList());
        } else {
            int[] nodesToGo = graph[i];
            for (int toGo : nodesToGo) {
                findAllPaths(graph, allPaths, csvList + "," + toGo, toGo);
            }
        }

    }
}
