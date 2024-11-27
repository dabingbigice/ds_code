package com.example._2024_11.链表;

public class _24_两两交换链表中的节点 {
    public class ListNode {
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

    /**
     * 思路：1.进行两个值的交换，判断next是否为空
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        while (pre.next != null && pre.next.next != null) {
            //进行值的交换
            int temp = pre.next.val;
            pre.next.val = pre.next.next.val;
            pre.next.next.val = temp;
            pre = pre.next.next;
        }


        return dummy.next;
    }
}
