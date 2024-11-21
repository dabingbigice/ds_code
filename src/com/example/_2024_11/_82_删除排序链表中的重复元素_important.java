package com.example._2024_11;

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


}
