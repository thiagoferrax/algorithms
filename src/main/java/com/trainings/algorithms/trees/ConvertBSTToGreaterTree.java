package com.trainings.algorithms.trees;

public class ConvertBSTToGreaterTree {
    public TreeNode convertBST(TreeNode root) {
        // Create a list of values with keys (List<Integer>)
        // [4, 1, 6, 0, 2, 5, 7, null, null , 3, null, null, null, 8]

        // Sort the list to make easy to calculate the sums
        // [8, 7, 6, 5, 4, 3, 2, 1, 0, null , null, null, null, null]

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

        // Update the tree to have the values.

        return root;
    }


}
