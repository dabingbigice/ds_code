package com.example._2024_11;

public class _61_旋转链表_important {
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
     * 思路：1.先遍历整个链表，统计出来节点个数，然后对k值进行相减。此时得到需要旋转的节点的pre。如果取余==0，那么不需要旋转
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1, head);
        ListNode countNode = head;
        int count = 0;
        while (countNode != null) {
            count++;
            countNode = countNode.next;
        }
        //得到需要旋转的尾部元素的个数
        int rota = k % count;
        if (rota == 0) return head;
        //获取正数的元素的pre
        int j = count - rota;
        //寻找pre指针
        count = 1;
        //head是第一个
        ListNode pre = head;
        while (count != j) {
            count++;
            pre = pre.next;
        }
        //拿到需要反转的重新插入的链表头部
        ListNode headNode = pre.next;
        //把整个链表单独拿出来
        pre.next = null;
        //获取尾部
        ListNode lastNode = headNode;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = dummy.next;
        dummy.next = headNode;
        return dummy.next;
    }

    public static void main(String[] args) {
        //[0,1,2]
        ListNode listNode = new ListNode(0, new ListNode(1, new ListNode(2, null)));
        rotateRight(listNode, 4);
    }
}
