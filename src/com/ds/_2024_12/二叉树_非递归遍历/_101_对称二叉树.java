package com.ds._2024_12.二叉树_非递归遍历;

public class _101_对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);

    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            //其中一颗为空
            return false;
        }
        //      1
        //     / \
        //    2   2
        //   / \ / \
        //  3  4 4  3
        //
        //      1
        //     / \
        //    2   2
        //     \   \
        //     3    3
        //left==right ,right ==left 对称
        return (left.val == right.val) && isMirror(left.left, right.right) && isMirror(left.right, right.left);

    }

    public boolean isSymmetric1(TreeNode root) {
        if (root == null) return true;

        return isMirror1(root.left, root.right);
    }

    private boolean isMirror1(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if ((left == null && right != null) || (right == null && left != null)) return false;
        if (left.val != right.val) return false;
        //如果相等就还需要继续对比左右孩子
        return isMirror1(left.left, right.right) && isMirror1(left.right, right.left);
    }
}
