package com.ds._2024_11.链表;

public class _328_奇偶链表_important {
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
     * 思路:你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。
     * 给定两个指针,步长都为2
     * int index1 = 1
     * int index2 =2
     * index1+=2
     * index2+=2
     * index1 :1,3,5,7,9
     * index2:2,4,6,8,10
     * 然后分别将这两个填入新的dummy节点中
     * 2.
     * 新建一个节点。每次都将偶节点的数据放入新节点。最后组合
     *
     * @param head
     * @return
     */
    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            //even.next!=null判断还有没有奇元素
            //even！=null 判断是否已经到了尾部
            odd.next = even.next;//删除偶元素
            odd = odd.next;
            //删除奇元素
            even.next = odd.next;
            even = even.next;

        }
        odd.next = evenHead;
        return head;
    }

    /**
     * 思路：一个指针指向奇数节点的头部。然后依次删除下一个节点并后移
     * 一个指针指向偶数节点的头部，然后依次删除下一个节点并后移
     *
     * @param head
     * @return
     */
    public static ListNode oddEvenList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode even = head.next;
        ListNode odd = head;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            odd=odd.next;
            even.next=even.next.next;
            even=even.next;

        }
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {

        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        oddEvenList(listNode);
    }
}
