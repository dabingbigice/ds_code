package com.ds._2024_12.栈;

import java.util.*;

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
            int len = queue.size();//先拿到当前层的长度，下一层开始的时候也是拿到当前层的数据
            //每次进入第一层while的时候都是拿到当前层的节点长度
            while (len > 0) {
                //只管遍历完当前层
                TreeNode poll = queue.poll();
                layerList.add(poll.val);

                if (poll.left != null) {
                    queue.add(poll.left);
                }

                if (poll.right != null) {
                    queue.add(poll.right);
                }
                //只管遍历完当前层
                len--;
            }
            list.add(layerList);
        }
        return list;
    }
}
