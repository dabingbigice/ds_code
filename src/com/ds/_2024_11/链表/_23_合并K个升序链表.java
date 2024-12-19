package com.ds._2024_11.链表;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _23_合并K个升序链表 {

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
     * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
     * 输出：[1,1,2,3,4,4,5,6]
     * 解释：链表数组如下：
     * [
     * 1->4->5,
     * 1->3->4,
     * 2->6
     * ]
     * 将它们合并到一个有序链表中得到。
     * 1->1->2->3->4->4->5->6
     * 1.for数组归并,链表两两合并
     * 2.将所有数据放入数组，然后排序，最后构造有序链表
     * * @param lists
     *
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;


        //lists[i].length 的总和不超过 10^4
        List list = new ArrayList<Integer>();
        for (int i = 0; i < lists.length; i++) {
            ListNode head = lists[i];
            while (head != null) {
                list.add(head.val);
                head = head.next;
            }
        }
        if (list.size() == 0) {
            return null;
        }
        Collections.sort(list);
        ListNode node = new ListNode((int) list.get(0), null);//
        ListNode head = node;//
        for (int i = 1; i < list.size(); i++) {
            ListNode next = new ListNode((int) list.get(i));
            node.next = next;
            node = node.next;
        }
        return head;
    }

    // 方法：创建链表
    public static ListNode createList(int[] values) {
        ListNode dummy = new ListNode(0); // 虚拟头节点
        ListNode current = dummy;
        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }
        return dummy.next;
    }

    // 方法：打印链表
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // 测试用例 1：正常情况
    public static ListNode[] generateTestCase1() {
        return new ListNode[]{
                createList(new int[]{1, 4, 5}),
                createList(new int[]{1, 3, 4}),
                createList(new int[]{2, 6})
        };
    }

    public static ListNode[] generateTestCase2() {
        return new ListNode[]{
                createList(new int[]{}),
                createList(new int[]{})
        };
    }

    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;//新的头节点构建新链表
        ListNode p1 = list1;
        ListNode p2 = list2;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                ListNode node = p1;
                p1 = p1.next;
                pre.next = node;
                node.next = null;
            } else {
                ListNode node = p2;
                p2 = p2.next;
                pre.next = node;
                node.next = null;
            }
            pre = pre.next;
        }
        if (p1 != null) {
            pre.next = p1;
        }
        if (p2 != null) {
            pre.next = p2;
        }

        return dummy.next;
    }

    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];

        ListNode listNode = mergeTwoLists1(lists[0], lists[1]);
        for (int i = 2; i < lists.length; i++) {
            if (lists[i] != null) {
                listNode = mergeTwoLists1(listNode, lists[i]);
            }
        }
        return listNode;
    }

    public static void main(String[] args) {
        System.out.println("Test Case 1:");
        mergeKLists(generateTestCase2());
        for (ListNode node : generateTestCase1()) {
            mergeKLists(generateTestCase2());
            _23_合并K个升序链表.printList(node);
        }
    }

}
