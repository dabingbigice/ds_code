package com.example._2024_11.链表;

public class _141_环形链表 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 跑圈，长跑问题。相遇问题，相遇表明有环
     * 两个指针，以不同的速度前进
     *
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;
        if (head.next == null) return false;

        ListNode p1 = head;
        //p1步长为1,p2步长为2。p2速度快
        ListNode p2 = head.next.next;
        while (p2 != null) {
            if (p1 == p2) {
                //如果相等，返回true
                return true;
            }
            if (p2.next != null && p2.next.next != null) {
                p1 = p1.next;
                p2 = p2.next.next;
            } else {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(3, null);
        ListNode listNode2 = new ListNode(2, listNode1);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(0, listNode2);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(-4, listNode2);
        listNode3.next = listNode4;

        hasCycle(listNode1);
    }
}
