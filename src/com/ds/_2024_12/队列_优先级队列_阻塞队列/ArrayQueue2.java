package com.ds._2024_12.队列_优先级队列_阻塞队列;

public class ArrayQueue2<E> implements Queue<E> {
    private E[] array;
    private int head = 0;
    private int tail = 0;
    private int size = 0;//添加一个长度来判断是否满。意义不大

    public ArrayQueue2() {
    }

    public ArrayQueue2(int capacity) {
        array = (E[]) new Object[capacity + 1];
    }

    public ArrayQueue2(E[] array, int head, int tail) {
        this.array = array;
        this.head = head;
        this.tail = tail;
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) return false;
        array[tail] = value;
        tail = (tail + 1) % array.length;
        size++;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) return null;
        E value = array[head];
        head = (head + 1) % array.length;
        size--;
        return value;
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;
        return array[head];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }
}
