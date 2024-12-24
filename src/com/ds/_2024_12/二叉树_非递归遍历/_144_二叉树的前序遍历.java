package com.ds._2024_12.二叉树_非递归遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _144_二叉树的前序遍历 {
    public static void preOder(TreeNode node) {
        if (node == null) return;
        System.out.println(node.val);
        preOder(node.left);
        preOder(node.right);
    }

    public static void midOder(TreeNode node) {
        if (node == null) return;
        midOder(node.left);
        System.out.println(node.val);
        midOder(node.right);
    }

    public static void postOder(TreeNode node) {
        if (node == null) return;
        postOder(node.left);
        postOder(node.right);
        System.out.println(node.val);
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
//        if (root == null) return new ArrayList<>();
//        Stack<TreeNode> stack = new Stack();
//        List<Integer> res = new ArrayList<>();
//        stack.push(root);
//        while (!stack.isEmpty()) {
//            TreeNode pop = stack.pop();
//            //前序添加自己
//            res.add(pop.val);
//            if (pop.right != null) {
//                stack.push(pop.right);
//            }
//            if (pop.left != null) {
//                stack.push(pop.left);
//            }
//        }
//        return res;
        Stack<TreeNode> stack = new Stack();
        TreeNode curr = root;
        while (curr != null && !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode pop = stack.pop();
                System.out.println(pop);
                curr = pop.right;
            }
        }
        return null;
    }

    public static List<Integer> midTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Stack<TreeNode> stack = new Stack();
        List<Integer> res = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode peek = stack.peek();
            if (peek.right != null) {
                stack.push(peek.right);
            }
            if (peek.left != null) {
                stack.push(peek.left);
            } else {
                int val = stack.pop().val;
                res.add(val);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4), 2, null),
                1,
                new TreeNode(new TreeNode(5), 3, new TreeNode(6))
        );
        preorderTraversal(root);

    }
}
