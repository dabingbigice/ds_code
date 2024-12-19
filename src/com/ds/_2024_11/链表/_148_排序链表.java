package com.ds._2024_11.链表;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _148_排序链表 {
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

    public ListNode sortList(ListNode head) {
        ListNode current = head;
        List list = new ArrayList<Integer>();
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }
        Collections.sort(list);
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        for (int i = 0; i < list.size(); i++) {
            pre.next = new ListNode((Integer) list.get(i));
            pre = pre.next;
        }
        return dummy.next;
    }

    /**
     * 使用插入排序，然后使用快慢指针获取中间节点，然后合并
     *
     * @param head
     * @return
     */
    public ListNode sortList1(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
        }
        //获取到了中间节点
        ListNode middle = fast;


        return null;
    }

    /**
     * 进行插入排序
     * current指针指向待排序。进行while循环搜索。直到p==current，那么此时指针不移动
     *
     * @return
     */
    public static ListNode insertSortList(ListNode head) {


        return null;
    }
}

