package com.example._2024_12.队列;

//双向循环队列
//删除时需要操作双向指针
public class LinkedListDeque_链表实现双端队列<E> implements Deque<E> {
    //sentinel的pre是尾部。next是头部。所以就不需要两个指针了。
    //这是一个循环队列
    Node<E> sentinel = new Node<>(null, null, null);
    int capacity = Integer.MAX_VALUE;
    int size;

    public LinkedListDeque_链表实现双端队列(int capacity) {
        sentinel.pre = sentinel;
        sentinel.next = sentinel;
    }

    static class Node<E> {
        Node<E> pre;
        Node<E> next;
        E val;

        public Node(Node<E> pre, E val, Node<E> next) {
            this.pre = pre;
            this.next = next;
            this.val = val;
        }

        public Node() {
        }
    }


    @Override
    public boolean offerFirst(E e) {
        if (isFull()) return false;
        Node a = sentinel;
        Node b = sentinel.next;
        //a add b
        Node<E> add = new Node<>(a, e, b);//组织新节点
        //修改老节点指向
        a.next = add;
        b.pre = add;
        size++;
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        if (isFull()) return false;
        // sentinel.pre add  sentinel
        Node<E> last = sentinel.pre;
        Node<E> head = sentinel;
        //组织新节点
        Node<E> node = new Node<>(last, e, head);
        //插入新节点
        last.next = node;
        head.pre = node;
        size++;
        return true;
    }

    @Override
    public E pollFirst() {
        if (isEmpty()) return null;
        Node<E> node = sentinel.next;
        sentinel.next = node.next;
        node.next.pre = sentinel;
        size--;
        return node.val;
    }

    @Override
    public E pollLast() {
        if (isEmpty()) return null;
        Node<E> node = sentinel.pre;
        sentinel.pre = node.pre;
        node.pre.next = sentinel;
        size--;
        return node.val;
    }

    @Override
    public E peekFirst() {
        if (isEmpty()) return null;
        return sentinel.next.val;
    }

    @Override
    public E peekLast() {
        if (isEmpty()) return null;

        return sentinel.pre.val;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }
}
