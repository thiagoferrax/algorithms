package com.trainings.algorithms.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return false;

        List<Integer> leftList = new ArrayList<>();
        readTree(root.left, SIDE.LEFT, leftList);

        List<Integer> rightList = new ArrayList<>(leftList.size());
        readTree(root.right, SIDE.RIGHT, rightList);

        return Arrays.equals(leftList.toArray(), rightList.toArray());
    }

    private void readTree(TreeNode node, SIDE side, List<Integer> list) {
        if (node != null) {
            list.add(node.val);
            if (side == SIDE.LEFT) {
                read(node.right, side, list);
                read(node.left, side, list);
            } else {
                read(node.left, side, list);
                read(node.right, side, list);
            }
        } else {
            list.add(null);
        }
    }

    private void read(TreeNode node, SIDE side, List<Integer> list) {
        if (node == null) {
            list.add(null);
        } else {
            readTree(node, side, list);
        }
    }

    enum SIDE {LEFT, RIGHT}
}
