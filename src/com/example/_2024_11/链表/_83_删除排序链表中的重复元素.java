package com.example._2024_11.链表;

public class _83_删除排序链表中的重复元素 {


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
     * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
     * <p>
     * 思路，双指针，pre和now,如果now==pre，则pre.next=now.next,直到now==null;
     *
     * @param head
     * @return
     */

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            //如果只有一个元素或者没有元素，直接返回
            return head;
        }

        ListNode pre = head;
        for (ListNode p = head.next; p != null; p = p.next) {
            if (pre.val == p.val) {
                //两个val相等进行链表删除
                pre.next = p.next;
            } else {
                //如果不等，则pre后移
                pre = p;
            }


        }
        return head;

    }
}
