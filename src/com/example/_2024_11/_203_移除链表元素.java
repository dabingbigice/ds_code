package com.example._2024_11;

import javax.print.Doc;

public class _203_移除链表元素 {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

    }

    /**
     * 思路:遍历链表，用一个Pre指针存储一下前一个节点
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;

        //当头节点元素等于val时
        while (head.val == val) {
            head = head.next;
            //过滤头元素相同的节点
            if (head == null) return null;
        }
        //头节点的值不等于val
        ListNode pre = head;
        for (ListNode p = head.next; p != null; p = p.next) {
            //当头节点元素等于val时,进行删除
            if (p.val == val) {
                //[1,3]
                //[1,2,6,3,4,5,6]
                //[1,2,3,4,5,6]
                //进行删除
                pre.next = p.next;
            } else {
                //如果不需要删除，才移动p。如果需要删除，此时不要移动pre,直接删除移动p
                pre = p;
            }
            //pre = pre.next;  错误语句，如果pre后面连着两个相同的元素，此时pre也会移动到需要删除的元素，而此时已经不能删除了
        }
        return head;
    }

}
