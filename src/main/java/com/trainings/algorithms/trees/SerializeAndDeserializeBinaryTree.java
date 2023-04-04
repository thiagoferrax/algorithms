package com.trainings.algorithms.trees;

public class SerializeAndDeserializeBinaryTree {


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        // Read the tree and then create an array and turn the array into a string

        // Edge cases...
        String tree;
        if(root == null) {
            return "[]";
        } else if (root.left == null && root.right == null){
            tree = "["+root.val+"]";
        } else {
            tree = serializeTree(root, "");

        }
        return tree;
    }

    private String serializeTree(TreeNode node, String tree) {
        if(node == null) {
            tree += "," + node;
            return tree;
        } else if(tree.isEmpty()) {
            tree += node.val;
        } else {
            tree += "," + node.val;
        }

        tree = serializeTree(node.left, tree);

        tree = serializeTree(node.right, tree);

        return tree;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        TreeNode root = null;
        if(data == null || data.isEmpty()) {
            return root;
        } else {
            boolean onlyOneElement = !data.contains(",");
            if(onlyOneElement) {
                return new TreeNode(Integer.parseInt(data));
            } else {
                String[] nodes = data.split(",");
                
                int i = 0;
                root = new TreeNode(Integer.parseInt(nodes[i]));
                createMagicTree(nodes, 0, root);
            }
        }

        return root;
    }

    private static int createMagicTree(String[] nodes, int i, TreeNode root) {
        int myIndex = i;
        if("null".equals(nodes[myIndex +1])) {
            root.left = null;
        } else {
            root.left = new TreeNode(Integer.parseInt(nodes[myIndex +1]));
            myIndex = createMagicTree(nodes, myIndex+1, root.left);
        }

        if("null".equals(nodes[myIndex + 2])) {
            root.right = null;
        } else {
            root.right = new TreeNode(Integer.parseInt(nodes[myIndex +2]));
            myIndex = createMagicTree(nodes, myIndex+2, root.right);
        }
        return  myIndex + 1;
    }

}
