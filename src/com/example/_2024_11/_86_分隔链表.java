package com.example._2024_11;


import java.util.ArrayList;
import java.util.List;

public class _86_分隔链表 {
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
     * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
     * 你应当 保留 两个分区中每个节点的初始相对位置。
     * 思路:
     * 遍历整个链表，把小于的放在一个数组，把大于或等于的的放在另一个。然后对两个数组分别进行链表的构造
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode current = head;
        List leftNodes = new ArrayList<Integer>();
        List rightNodes = new ArrayList<Integer>();
        while (current != null) {
            if (current.val < x) {
                leftNodes.add(current.val);
            } else {
                rightNodes.add(current.val);
            }
            current = current.next;
        }
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        for (int i = 0; i < leftNodes.size(); i++) {
            Object o = leftNodes.get(i);
            ListNode listNode = new ListNode((Integer) o);
            pre.next = listNode;
            pre = pre.next;
        }
        for (int i = 0; i < rightNodes.size(); i++) {
            Object o = rightNodes.get(i);
            ListNode listNode = new ListNode((Integer) o);
            pre.next = listNode;
            pre = pre.next;
        }
        return dummy.next;
    }

    /**
     * 维护两个链表，最后把他们拼接起来。将小于的构成一个，大于等于的构成一个
     *
     * @param head
     * @param x
     * @return
     */
    public static ListNode partition2(ListNode head, int x) {
        ListNode smallDummy = new ListNode(-1);
        ListNode smallPre = smallDummy;
        ListNode largerDummy = new ListNode(-1);
        ListNode largerPre = largerDummy;
        while (head != null) {
            if (head.val < x) {
                //小的
                smallPre.next = new ListNode(head.val);
                smallPre = smallPre.next;
            } else {
                largerPre.next = new ListNode(head.val);
                largerPre = largerPre.next;
            }
            head = head.next;
        }
        smallPre.next=largerDummy.next;
        return smallDummy.next;
    }

    public static void main(String[] args) {

    }
}
