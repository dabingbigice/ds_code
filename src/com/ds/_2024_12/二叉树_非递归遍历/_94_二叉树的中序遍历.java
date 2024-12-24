package com.ds._2024_12.二叉树_非递归遍历;

import java.util.ArrayList;
import java.util.List;

public class _94_二叉树的中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        mid(root,list);
        return list;
    }

    private void mid(TreeNode root, List<Integer> list) {
        if (root==null) return;
        mid(root.left,list);
        list.add(root.val);
        mid(root.right,list);
    }
}
