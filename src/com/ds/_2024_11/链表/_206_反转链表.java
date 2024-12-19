package com.ds._2024_11.链表;

import org.junit.jupiter.api.Test;

public class _206_反转链表 {
    public class ListNode {
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
     * 思路：1.新建一个链表一直循环
     * 2.新建一个数组，添加好所有的元素，然后新建一个链表进行添加
     * 3.头插法
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        //反转,先取出第一个元素进行构建
        ListNode listNode = new ListNode();
        listNode.val = head.val;
        for (ListNode p = head.next; p != null; p = p.next) {
            //从第二个元素开始
            ListNode newHeadNode = new ListNode();
            newHeadNode.val = p.val;
            //把原来的头节点挂到新链表下
            newHeadNode.next = listNode;
            //再把新链表更改为头节点完成替换
            listNode = newHeadNode;
        }
        return listNode;
    }

    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //头插法
        ListNode current = head;
        ListNode dummy = new ListNode(-1, null);
        while (current != null) {
            ListNode listNode = new ListNode(current.val);
            listNode.next = dummy.next;
            dummy.next = listNode;
            current = current.next;
        }

        return dummy.next;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //头插法，从旧链表的头部移走，移到新链表的头部
        ListNode current = head;
        ListNode dummy = new ListNode(-1, null);
        while (current != null) {
            //拿到当前节点
            ListNode node = current;
            //先移走
            current = current.next;
            //再操作
            node.next = dummy.next;
            dummy.next = node;
        }

        return dummy.next;
    }

    public ListNode reverseList3(ListNode head) {
        //递归，递的终止条件
        if (head == null || head.next == null) {
            return head;
        }
        //传进去的是head.next。4->5.此时传进去的是5.head还是4。必须传next,反转当前节点和next节点
        ListNode listNode = reverseList3(head.next);
        //当前方法还能获取到head
        head.next.next = head;
        head.next = null;//破除环,原地反转。归出来的是每个节点，直接利用。
        return listNode;//相当于拿最后一个节点做头节点
    }

    @Test
    public void test() {

    }
}
