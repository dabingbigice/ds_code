package com.ds._2024_12.二叉树_非递归遍历;

import java.util.ArrayList;
import java.util.List;

public class _145_二叉树的后序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        last(root,list);
        return list;
    }

    private void last(TreeNode root, List<Integer> list) {
        if (root==null) return;
        last(root.left,list);
        last(root.right,list);
        list.add(root.val);
    }
}
