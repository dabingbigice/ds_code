package com.example._2024_12.栈;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class _102二叉树的层序遍历 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //第一次只有一个节点
        while (!queue.isEmpty()) {
            //每一层要个
            ArrayList<Integer> layerList = new ArrayList<>();
            //相当于记录下一层添加了的节点个数
            int len = queue.size();
            while (len > 0) {
                TreeNode poll = queue.poll();
                layerList.add(poll.val);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
                len--;
            }
            list.add(layerList);
        }
        return list;
    }
}
