package com.example._2024_11.链表;

public class _147_对链表进行插入排序_important {
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
     * 思路：新建一个头节点，遍历head节点。每次拿一个node去dummy中从头比较。寻找插入位置
     * 找到插入位置后，先移动head节点。然后用current节点进行赋值
     *
     * @param head
     * @return
     */
    public static ListNode insertionSortList(ListNode head) {
        if (head == null && head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        while (head != null) {
            ListNode pre = dummy;
            ListNode current = head;
            //用current去新节点dummy中搜索
            while (pre.next != null && pre.next.val < current.val) {
                pre = pre.next;
            }
            //搜索到了大于的节点 pre.next.val大于current.val
            //替换
            head = head.next;
            //插入
            current.next = pre.next;
            pre.next = current;
        }

        return dummy.next;

    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(5, new ListNode(3, new ListNode(4))));
        insertionSortList(listNode);
    }
}
