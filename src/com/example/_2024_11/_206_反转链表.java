package com.example._2024_11;

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

    @Test
    public void test() {

    }
}
