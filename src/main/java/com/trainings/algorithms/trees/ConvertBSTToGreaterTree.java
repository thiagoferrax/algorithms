package com.trainings.algorithms.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertBSTToGreaterTree {
    public TreeNode convertBST(TreeNode root) {
        // Create a list of values with keys (List<Integer>)
        // [4, 1, 6, 0, 2, 5, 7, null, null , 3, null, null, null, 8]

        Map<Integer, Integer> keySumMap = new HashMap<>();

        buildKeySumMap(root, keySumMap);

        //System.out.println(keySumMap);

        // Sort the list to make easy to calculate the sums
        // [8, 7, 6, 5, 4, 3, 2, 1, 0, null , null, null, null, null]

        List<Integer> sortedKeys = new ArrayList<>(keySumMap.keySet());
        sortedKeys.sort((o1, o2) -> {
            if(o2!=null && o1!=null) return o2 - o1;
            else return 0;
        });

        //System.out.println(sortedKeys);

        // Create a map key => sum
        // int previousSum = 0;
        // Iterate throught the sorted list and create a map.
        // {
        // 8 => 8
        // int previousSum = 8;
        // 7 => 15
        // int previousSum = 15;
        // 6 => 21
        // int previousSum = 21;
        // 5 => 26
        // int previousSum = 26;
        // 4 => 30
        // int previousSum = 30;
        // 3 => 33
        // int previousSum = 33;
        // 2 => 35
        // int previousSum = 35;
        // 1 => 36
        // int previousSum = 36;
        // 0 => 36
        // }

        int previousSum = 0;
        for (Integer key: sortedKeys) {
            previousSum += key;
            keySumMap.put(key, previousSum);
        }

        //System.out.println(keySumMap);

        // Update the tree to have the values.
        updateTree(root, keySumMap);

        return root;
    }

    private void updateTree(TreeNode node, Map<Integer, Integer> keySumMap) {
        if(node!=null) {
            node.val = keySumMap.get(node.val);
            updateTree(node.left, keySumMap);
            updateTree(node.right, keySumMap);
        }
    }

    private static void buildKeySumMap(TreeNode node, Map<Integer, Integer> keySumMap) {
        if(node != null) {
            keySumMap.put(node.val, 0);
            buildKeySumMap(node.left, keySumMap);
            buildKeySumMap(node.right, keySumMap);
        }
    }


}
