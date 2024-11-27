package com.example._2024_11.链表;

import java.util.List;
import java.util.Map;
import java.util.Stack;

public class _143_重排链表 {
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
     * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
     * <p>
     * L0 → L1 → … → Ln - 1 → Ln
     * 请将其重新排列后变为：
     * <p>
     * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
     * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     * <p>
     * 思路：
     * 1.获取整个链表的后半部分，不管链表长度是奇数还是偶数，
     * 都直接/2获取pre的指针。然后把pre后的数据进行反转。最后依次插入。
     * 2.快慢指针能用于去找到中间节点。慢指针走1步，快指针走2步，当快指针==null时，慢指针刚好在中间
     * 反转链表可以使用栈进行操作，将所有数据存入栈
     *
     *
     * @param head
     */
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode dummy = new ListNode(-1, head);
        //进行计数
        /*ListNode currentCount = head;
        int count = 0;
        while (currentCount != null) {
            count++;
            currentCount = currentCount.next;
        }
        //从1开始计数
        int preIndex = count / 2;
        int j = 1;
        ListNode pre = head;
        while (j != preIndex) {
            pre = pre.next;
            j++;
        }*/
        //获取到pre指针了,将pre后的节点进行断开,拿到需要反转的链表的head=current
        // ListNode current = pre.next;
        // pre.next = null;
        ListNode middle = getMiddle(head);
        ListNode current = middle.next;
        middle.next = null;
        Stack<ListNode> stack = new Stack<>();
        //将每个节点压入栈中
        while (current != null) {
            ListNode c = current;
            stack.push(current);
            //pre后移
            current = current.next;
            //这里是把当前节点的下一个链表给删除，相当于栈里面存储的是单个节点，
            // 而不是之后的整个链表
            c.next = null;
        }
        //整个压入栈了之后可以弹出来将链表进行组合
        ListNode insertNode = head;
        ListNode pop = null;
        while (insertNode != null && !stack.empty()) {
            //先后移拿到后一个节点
            ListNode nextNode = insertNode.next;
            pop = stack.pop();
            //将后一个节点挂在当前要插入的节点的下一个节点
            pop.next = nextNode;
            insertNode.next = pop;
            insertNode = nextNode;
        }
        //将栈中剩余的都添加到链表
        while (!stack.empty()) {
            ListNode stackLastNode = stack.pop();
            pop.next = stackLastNode;
            //pop后移
            pop = stackLastNode;
        }

    }

    /**
     * 使用快慢指针找中间节点
     *
     * @param
     */
    public static ListNode getMiddle(ListNode head) {
        //慢指针1步
        ListNode slow = head;
        //快指针两步
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        reorderList(listNode);
    }
}
