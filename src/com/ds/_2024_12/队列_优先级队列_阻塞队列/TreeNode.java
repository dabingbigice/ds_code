package com.ds._2024_12.队列_优先级队列_阻塞队列;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode( TreeNode left,int val, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
