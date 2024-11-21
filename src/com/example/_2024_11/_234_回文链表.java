package com.example._2024_11;

import java.time.chrono.IsoChronology;

import static com.example._2024_11._19_删除链表的倒数第N个结点.revers;

public class _234_回文链表 {
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
     * 思路：先统计数据,获取中间的指针，然后进行比较，知道head指针==middle.next指针
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }
        int count = 0;
        ListNode node = head;
        while (node != null) {
            count++;
            node = node.next;
        }
        //[1,2,2,1]
        //统计完成
        node = head;
        //拿到另一半的头指针
        int j = 0;
        ListNode pointer = null;
        int k = count / 2;
        while (k != j) {
            j++;
            pointer = node;
            node = node.next;
        }
        //获取到了中间节点pointer,将这个的next作为另一半指针
        ListNode otherHead = pointer.next;
        otherHead = revers(otherHead);
        while (otherHead != null) {
            if (otherHead.val != head.val) {
                return false;
            }
            otherHead = otherHead.next;
            head = head.next;
        }
        return true;
    }

    public static ListNode revers(ListNode head) {
        //使用头节点
        ListNode dummy = new ListNode(-1, null);
        while (head != null) {
            ListNode listNode = new ListNode(head.val, null);
            listNode.next = dummy.next;
            dummy.next = listNode;
            head = head.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        isPalindrome(head);

    }
}
