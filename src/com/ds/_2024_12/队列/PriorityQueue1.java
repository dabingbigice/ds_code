package com.ds._2024_12.队列;

public class PriorityQueue1<E extends Priority> implements Queue<E> {
    Priority[] priorities;
    int size;

    @Override
    public boolean offer(E value) {
        if (isFull()) return false;
        priorities[size++] = value;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) return null;
        int index = findIndex();
        E element = (E) priorities[index];
        for (int i = index; i < size - 2; i++) {
            priorities[i] = priorities[i + 1];
        }
        size--;
        return element;
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;
        return (E) priorities[findIndex()];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == priorities.length;
    }

    public int findIndex() {
        int maxIndex = 0;
        int val = priorities[0].priority();
        for (int i = 1; i < size; i++) {
            if (priorities[i].priority() > val) {
                val = priorities[i].priority();
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
