package com.trainings.algorithms.trees;

import java.util.*;

public class BinarySearchTreeLowestCommonAncestor {
    public static Node lca(Node root, int v1, int v2) {
        if(root == null) {
            return null;
        }

        Map<Integer, Node> nodeMap = new HashMap<>();
        Map<Integer, List<Integer>> parentMap = new HashMap<>();
        parentMap.put(root.data, new ArrayList<>());

        lca(root, nodeMap, parentMap);

        List<Integer> v1Parents = parentMap.get(v1);
        List<Integer> v2Parents = parentMap.get(v2);
        v1Parents.retainAll(v2Parents);

        if(v1Parents.contains(v2)) {
            return nodeMap.get(v2);
        } else if (v2Parents.contains(v1)) {
            return nodeMap.get(v1);
        }

        return v1Parents.isEmpty() ?  root : nodeMap.get(v1Parents.get(v1Parents.size()-1));
    }

    private static void lca(Node node, Map<Integer, Node> nodeMap, Map<Integer, List<Integer>> parentMap) {
        nodeMap.put(node.data, node);

        List<Integer> parents = new ArrayList<>(parentMap.getOrDefault(node.data, new ArrayList<>()));
        parents.add(node.data);

        if(node.left != null) {
            parentMap.put(node.left.data, parents);
            lca(node.left, nodeMap, parentMap);
        }
        if(node.right != null) {
            parentMap.put(node.right.data, parents);
            lca(node.right, nodeMap, parentMap);
        }
    }

}
