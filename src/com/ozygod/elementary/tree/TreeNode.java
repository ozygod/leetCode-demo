package com.ozygod.elementary.tree;

public class TreeNode {
    int val;
    TreeNode leftNode;
    TreeNode rightNode;
    TreeNode(){}
    TreeNode(int val) { this.val = val; }

    public TreeNode(int val, TreeNode leftNode, TreeNode rightNode) {
        this.val = val;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    @Override
    public String toString() {
        return "[" +
                "val=" + val +
                ", left=" + leftNode +
                ", right=" + rightNode +
                ']';
    }
}
