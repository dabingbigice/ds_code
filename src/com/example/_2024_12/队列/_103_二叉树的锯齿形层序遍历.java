package com.example._2024_12.队列;

import java.util.*;

public class _103_二叉树的锯齿形层序遍历 {
    class TreeNode {
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> bigList = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList();
        queue.offer(root);
        int a = 1;
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> list = new ArrayList<>();
            while (len > 0) {
                TreeNode poll = queue.poll();
                len--;
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
                list.add(poll.val);
            }

            if (a % 2 == 0) {
                Collections.reverse(list);
            }
            a++;
            bigList.add(list);
        }
        return bigList;
    }
}
