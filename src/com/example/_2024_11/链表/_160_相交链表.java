package com.example._2024_11.链表;


import java.util.HashSet;
import java.util.List;

public class _160_相交链表 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 思路：1.判断两个链表是否为空，将next节点加入到set集合中，如果相等则跳出，并返回当前p，将两个链表同时移动。
     * 先将一个head全部添加进入set,然后再移动另外一个，这样可以防止a,b长度不一样。
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        if (headA == headB) {
            return headA;
        }
        HashSet<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
