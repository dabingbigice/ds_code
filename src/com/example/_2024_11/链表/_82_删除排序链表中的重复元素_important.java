package com.example._2024_11.链表;

public class _82_删除排序链表中的重复元素_important {
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
     * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
     * 只要当前有元素重复了，那么就要进行删除整个元素
     * 思路：
     * 1.pre指针和now指针，判断now.next==now?,注意防止now为空,添加头节点防止数据全部一样
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //以下保证至少有2个节点
        ListNode dummy = new ListNode(-101, head);
        //拿到pre指针
        ListNode pre = dummy;
        ListNode current = head;
        while (current != null) {
            if (current.next != null && current.val == current.next.val) {
                //当前数据等于下一个节点的数据说明重复了
                //进行删除
                //把判空放弃前面
                while (current.next != null && current.val == current.next.val) {
                    //将当前的指针后移
                    current = current.next;
                }
                pre.next = current.next;//将最后那个重复的数据移除。最重要的操作
                //删完后。pre不移动、
            } else {
                //没删除，移动pre
                pre = pre.next;
            }
            current = current.next;

        }
        return dummy.next;
    }

    public static ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode p1 = dummy;
        ListNode p2 = head;
        ListNode p3 = head.next;
        while (p3 != null) {
            boolean flag = false;
            //删除重复节点
            while (p3 != null && p2.val == p3.val) {
                p2.next = p3.next;//删除p3
                p3 = p3.next;
                flag = true;
            }
            //删除最先重复的那一个
            if (flag) {
                p1.next = p3;
                p2 = p3;
                if (p2 != null) p3 = p3.next;
            } else {
                p1 = p2;
                p2 = p3;
                p3 = p3.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
        deleteDuplicates2(listNode);
    }
}
