package com.trainings.algorithms.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SymmetricTree {

    enum SIDE {LEFT, RIGHT};
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return false;

        List<Integer> leftList = new ArrayList<>();
        readTree(root.left, SIDE.LEFT, leftList);

        List<Integer> rightList = new ArrayList<>(leftList.size());
        readTree(root.right, SIDE.RIGHT, rightList);

        System.out.println(leftList);
        System.out.println(rightList);

        return Arrays.equals(leftList.toArray(), rightList.toArray());
    }

    private void readTree(TreeNode node, SIDE side, List<Integer> list) {
        if(node != null) {
            list.add(node.val);
            if(side == SIDE.LEFT) {
                readTree(node.right, side, list);
                readTree(node.left, side, list);
            } else {
                readTree(node.left, side, list);
                readTree(node.right, side, list);
            }
        } else {
            list.add(null);
        }
    }
}
