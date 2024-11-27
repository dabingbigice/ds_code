package com.example._2024_11.链表;

public class _876_链表的中间结点 {
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

    /***
     * 思路,直接计数。然后把统计的数/2就可以到需要删除的数据的pre节点，然后再删除这个节点
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        int count = 0;
        if (head.next==null) return head;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        //统计完成了，让count直接到需要删除元素的前一个数据
        count = count / 2;
        int index = 1;
        while (count != index) {
            head = head.next;
            index++;
        }
        head = head.next;
        //然后进行删除count前的数据
        return head;
    }

}
