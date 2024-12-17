package com.example._2024_12.栈;

public class LinkedListStack<E> implements Stack<E> {
    private int size;
    private int capacity;

    //head->null
    private Node<E> head = new Node<>(null, null);

    public LinkedListStack(int capacity) {
        this.capacity = capacity;
    }

    static class Node<E> {
        E value;
        Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    //2->1->null
    @Override
    public boolean push(E value) {
        if (isFull()) return false;
        //把新节点挂到head的next节点上
        head.next = new Node<>(value, head.next);//将head的next挂在当前节点上，然后将当前节点挂在head.next下
        size++;
        return true;
    }

    @Override
    public E pop() {
        if (isEmpty()) return null;
        Node<E> node = head.next;
        //下移
        head.next = node.next;
        size--;
        return node.value;
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;
        return head.next.value;
    }

    @Override
    public boolean isEmpty() {
        return head.next == null;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }
}
