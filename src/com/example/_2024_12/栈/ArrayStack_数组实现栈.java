package com.example._2024_12.栈;

public class ArrayStack_数组实现栈<E> implements Stack<E> {
    private E[] arr;
    private int top;

    private int size;
    private int capacity;

    public ArrayStack_数组实现栈(int capacity) {
        this.capacity = capacity;
        arr = (E[]) new Object[capacity];
    }

    @Override
    public boolean push(E value) {
        if (isFull()) return false;
        arr[top]=value;
        top++;
        return true;
    }

    @Override
    public E pop() {
        if (isEmpty()) return null;
        E val = arr[top-1];
        top--;
        return val;
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;

        return arr[top-1];
    }

    @Override
    public boolean isEmpty() {
        return top==0;
    }

    @Override
    public boolean isFull() {
        return top==arr.length;
    }
}
