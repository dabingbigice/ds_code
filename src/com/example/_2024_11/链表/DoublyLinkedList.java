package com.example._2024_11.链表;

public class DoublyLinkedList {
    private Node head;//头
    private Node last;//尾部

    static class Node {
        Node pre;
        int val;

        Node next;


        public Node(int val) {
            this.val = val;
        }

        public Node(Node pre, int val, Node next) {
            this.pre = pre;
            this.val = val;
            this.next = next;
        }

        public Node() {
        }

        public Node(Node pre, Node next) {
            this.pre = pre;
            this.next = next;
        }

    }

    public DoublyLinkedList() {
        head = new Node(null, -1, null);
        last = new Node(null, -1, null);
        head.next = last;
        last.pre = head;
    }

    private Node findByIndex(int index) {
        if (index < 0) return head;
        int j = 0;
        for (Node p = head.next; p != last; p = p.next, j++) {
            if (j == index) {
                return p;
            }
        }
        return null;
    }

    public void insertNode(int index, Node node) throws Exception {
        Node pre = findByIndex(index - 1);
        if (pre == null) throw new Exception("索引错误");
        //修改node的next指针
        node.next = pre.next;
        pre.next.pre = node;
        //修改pre的next指针
        pre.next = node;
        node.pre = pre;
    }

    public void remove(int index) {
        Node pre = findByIndex(index - 1);
        if (pre == null) return;
        pre.next = pre.next.next;
        pre.next.pre = pre;
    }

    public static void main(String[] args) throws Exception {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertNode(0, new Node(1));
        doublyLinkedList.insertNode(0, new Node(2));
        doublyLinkedList.remove(0);
        doublyLinkedList.remove(0);
    }
}
