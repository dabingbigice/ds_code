package com.example._2024_11.链表;

public class _21_合并两个有序链表 {
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
     * 新建一个list，轮流比较两个移动的指针的值，如果一个为null了，直接把另一个挂在最后
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1, null);
        ListNode pre = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                ListNode listNode = new ListNode(list1.val);
                pre.next = listNode;
                list1 = list1.next;
            } else {
                pre.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            pre = pre.next;
        }
        if (list1 == null) {
            pre.next = list2;
        }
        if (list2 == null) {
            pre.next = list1;
        }
        return dummy.next;
    }
}
