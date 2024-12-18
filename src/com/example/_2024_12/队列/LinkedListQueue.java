package com.example._2024_12.队列;

public class LinkedListQueue<E> implements Queue<E> {
    //这里没有pre,所以那不到尾部。不是循环队列
    Node<E> head = new Node<>(null, null);
    Node<E> tail = head;

    private static class Node<E> {
        E value;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }

        Node<E> next;
    }

    public LinkedListQueue() {
        tail.next = head;
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) return false;
        size++;
        Node<E> node = new Node<>(value, head);
        tail.next = node;
        tail = node;
        return true;
    }

    int size = 0;
    int capacity = Integer.MAX_VALUE;


    @Override
    public boolean isFull() {
        return capacity == size;
    }

    @Override
    public E poll() {
        if (isEmpty()) return null;
        //先拿到数据
        Node<E> first = head.next;
        //进行删除
        head.next = first.next;
        if (head.next == head) tail = head;
        size--;
        return first.value;
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;
        return head.next.value;

    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }
}
