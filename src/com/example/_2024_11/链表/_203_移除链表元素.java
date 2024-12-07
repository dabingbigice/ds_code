package com.example._2024_11.链表;

import javax.print.Doc;

public class _203_移除链表元素 {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 思路:遍历链表，用一个Pre指针存储一下前一个节点
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;

        //当头节点元素等于val时
        while (head.val == val) {
            head = head.next;
            //过滤头元素相同的节点
            if (head == null) return null;
        }
        //头节点的值不等于val
        ListNode pre = head.next;
        while (pre.next != null) {
            if (pre.next.val == val) {
                //值相同,pre不移动，将next.next赋值给next完成删除
                pre.next = pre.next.next;
            } else {
                //如果值不相等,pre后移
                pre = pre.next;
            }
        }
        return head;
    }


    public ListNode removeElements1(ListNode head, int val) {
        //判断p2是否为null
        if (head == null) return null;
        ListNode dummy = new ListNode(-1, head);
        ListNode p1 = dummy;
        ListNode p2 = head;
        while (p2 != null) {
            if (p2.val == val) {
                p1.next = p2.next;
            } else {
                p1 = p1.next;
            }
            p2 = p2.next;

        }

        return dummy.next;
    }

    public ListNode removeElements2(ListNode head, int val) {

        return null;
    }
}
