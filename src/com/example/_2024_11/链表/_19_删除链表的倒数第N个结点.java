package com.example._2024_11.链表;

import java.util.Stack;

public class _19_删除链表的倒数第N个结点 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {

        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。

    /**
     * 思路：使用栈。带头结点的
     * 将所有头节点压栈，然后按顺序弹出就是倒数的节点。只需要将当前要删除的数据的node.next赋值给pre
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head.next == null && n == 1) {
            return null;
        }
        ListNode dummy = new ListNode(-1, head);
        Stack<ListNode> stack = new Stack<>();
        ListNode p = dummy;
        while (p != null) {
            stack.push(p);
            p = p.next;
        }
        int j = 1;
        //弹出节点
        while (j <= n) {
            //一直弹出
            stack.pop();
            j++;
        }
        //直到j>n，这个时候栈顶元素就是需要删除的元素的前一个元素

        ListNode pre = stack.pop();
        pre.next = pre.next.next;
        return dummy.next;
    }

    /**
     * 思路:1.如果只有一个元素，直接赋值为null
     * 2.先将链表倒置，然后就直接顺着删除/顺着遍历然后计数，最后再遍历一遍删除指定元素（复杂）
     * 3.反转再反转，空间复杂度高，时间复杂度也高
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //如果只有一个元素，直接赋值为null
        if (n == 1 && head.next == null) return null;
        //进行反转
        ListNode revers = revers(head);

        ListNode pre = revers;
        //不带头节点，此时需要删除头
        if (n == 1) {
            pre = pre.next;
            return revers(revers);
        }
        int j = 2;
        while (j != n) {
            //一直后移,直到j==1
            pre = pre.next;
            j++;
        }
        //当j=i了，这个时候进行删除
        pre.next = pre.next.next;
        return revers(revers);
    }

    public static ListNode revers(ListNode head) {

        ListNode listNode = new ListNode(head.val, null);
        //反转
        while (head.next != null) {
            ListNode node = new ListNode();
            //将head的下一个数据
            node.val = head.next.val;
            //将之前的数据挂在新的链表上
            node.next = listNode;
            //再将处理完的节点赋值给新的链表
            listNode = node;
            head = head.next;
        }
        return listNode;
    }

    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        recrusion(dummy, n);
        return dummy.next;
    }

    private static int recrusion(ListNode p, int n) {
        if (p == null) return 0;
        //要传p.next才好，不然删除不了
        int nth = recrusion(p.next, n);//nth表示下一个节点的位置，而不是当前位置的位置。使用当前位置去删除下一个节点的位置
        if (nth == n) {
            p.next = p.next.next;
        }
        return nth + 1;
    }

    public static ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode node = dummy;
        Stack<ListNode> stack = new Stack<>();
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        int j = 0;
        while (j != n) {
            stack.pop();
            j++;
        }
        ListNode pop = stack.pop();
        pop.next = pop.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        //[1,2,3]
        //ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, null)));
        ListNode head = new ListNode(1, new ListNode(2, null));
        ListNode node = removeNthFromEnd2(head, 2);
    }
}
