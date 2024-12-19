package com.ds._2024_11.链表;

public class _92_反转链表II_important {
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
     * 思路：进行遍历，先找到leftnode的pre,然后拿到pre的next,
     * 然后继续进行搜索right，拿到right的next.这样我就拿到
     * 了整个不需要反转的pre和next，接下来进行中间链表的反转
     * 最后把反转完的node进行拼接。把next加在后面，pre.next=反转的head
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return null;
        if (left == right) return head;
        ListNode dummy = new ListNode(-1, head);
        ListNode leftNodePre = dummy;
        int j = 0;
        //先找到leftnode的pre
        while (j != left - 1) {
            leftNodePre = head;
            head = head.next;
            j++;
        }
        //循环结束，j==left-1拿到leftNodePre了
        ListNode rightNodeNext = leftNodePre;
        while (j != right + 1) {
            rightNodeNext = head;
            if (head != null) {
                head = head.next;
            }
            j++;

        }
        //循环结束，j==right+1拿到rightNodePre了
        ListNode reversNode = new ListNode(-1);
        ListNode reversStart = leftNodePre.next;
        ListNode reversEnd = null;
        int count = 0;
        while (reversStart != rightNodeNext) {
            ListNode listNode = new ListNode(reversStart.val);
            if (count == 0)
                reversEnd = listNode;
            listNode.next = reversNode.next;
            reversNode.next = listNode;
            reversStart = reversStart.next;
            count++;
        }
        reversEnd.next = rightNodeNext;
        leftNodePre.next = reversNode.next;

        //进行反转
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(3, new ListNode(5));
        reverseBetween(listNode, 1, 2);
    }
}
