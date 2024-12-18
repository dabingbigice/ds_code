package com.example._2024_12.队列;

import java.util.jar.JarEntry;

public class ArrayDeque1_数组实现双端队列<E> implements Deque<E> {
    static int inc(int i, int len) {
        return i + 1 >= len ? 0 : i + 1;
    }

    static int dec(int i, int len) {
        return i - 1 < 0 ? len - 1 : i - 1;
    }

    E arr[];
    int head;
    int tail;
    int capacity;

    public ArrayDeque1_数组实现双端队列(int capacity) {
        this.capacity = capacity;
        arr = (E[]) new Object[capacity + 1];

    }

    @Override
    public boolean offerFirst(E o) {
        if (isFull()) return false;
        head = dec(head, arr.length);
        arr[head] = (E) o;
        return true;
    }

    @Override
    public boolean offerLast(E o) {
        if (isFull()) return false;
        arr[tail] = o;
        tail = inc(tail, arr.length);
        return true;
    }

    @Override
    public E pollFirst() {
        if (isEmpty()) return null;
        E e = arr[head];
        arr[head] = null;
        head = inc(head, arr.length);
        return e;
    }

    @Override
    public E pollLast() {
        if (isEmpty()) return null;
        tail = dec(tail, arr.length);
        E e = arr[tail];
        arr[tail] = null;
        return e;
    }

    @Override
    public E peekFirst() {
        if (isEmpty()) return null;

        return arr[head];
    }

    @Override
    public E peekLast() {
        if (isEmpty()) return null;
        return arr[dec(tail, arr.length)];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return (tail + 1) % arr.length == head;
    }
}
