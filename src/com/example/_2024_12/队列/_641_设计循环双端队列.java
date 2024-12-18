package com.example._2024_12.队列;

class _641_设计循环双端队列 {
    int arr[];
    int head;
    int tail;
    int size;
    int capacity;

    static int inc(int i, int capacity) {
        //回到头部
        return i + 1 == capacity ? 0 : i + 1;
    }

    static int dec(int i, int capacity) {
        //回到尾部
        return i - 1 < 0 ? capacity - 1 : i - 1;
    }

    public _641_设计循环双端队列(int k) {
        arr = new int[k + 1];
        this.capacity = k;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        head = dec(head, this.capacity);
        arr[head] = value;
        size++;
        return true;

    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        arr[tail] = value;
        tail = inc(tail, this.capacity);
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        head = inc(head, this.capacity);
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        tail = dec(tail, this.capacity);
        size--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) return -1;
        return arr[head];
    }

    public int getRear() {
        if (isEmpty()) return -1;
        return arr[dec(tail,this.capacity)];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}

