package com.example._2024_11;

public class _82 {
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

    /**
     * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        //头节点
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                //进行节点的删除
                while (head.next != null && head.val == head.next.val) {
                    //删除
                    head.next = head.next.next;
                }
                //出循环之后还要把最后一个重复的删了
                pre.next = head.next;
                //pre不用移动，但是head需要移动,head还是指向那个重复的元素，如果head不移动
                head = head.next;
            } else {
                //pre指针后移
                pre = pre.next;
                head = head.next;
            }
            //head后移

        }
        return dummy.next;
    }
}
