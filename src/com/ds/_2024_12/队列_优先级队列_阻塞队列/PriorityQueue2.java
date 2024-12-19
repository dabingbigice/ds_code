package com.ds._2024_12.队列_优先级队列_阻塞队列;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PriorityQueue2<E extends Priority> implements Queue<E> {
    Priority priority[];
    int size;

    public PriorityQueue2(int size) {
        priority = new Priority[size];
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) return false;
        insert(value);
        size++;
        return true;
    }

    public void insert(E value) {
        int index = size;
        while (index > 0 && value.priority() < priority[index - 1].priority()) {
            priority[index] = priority[index - 1];
            index--;
        }
        priority[index] = value;
    }


    @Override
    public E poll() {
        if (isEmpty()) return null;
        //删除尾部
        Priority e = priority[size - 1];
        priority[size - 1] = null;
        size--;
        return (E) e;
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;

        return (E) priority[size - 1];
    }

    public int findIndex() {
        int val = priority[0].priority();
        int index = 0;
        for (int i = 1; i < size; i++) {
            if (val < priority[i].priority()) {
                val = priority[i].priority();
                index = i;
            }
        }
        return index;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == priority.length;
    }

    public static void main(String[] args) {
        PriorityQueue2<Entry> queue = new PriorityQueue2<>(5);
        queue.offer(new Entry("task1", 4));
        queue.offer(new Entry("task2", 3));
        queue.offer(new Entry("task3", 2));
        queue.offer(new Entry("task4", 5));
        queue.offer(new Entry("task5", 1));
        assertFalse(queue.offer(new Entry("task6", 7)));

        assertEquals("task4", queue.peek().value);
        assertEquals("task4", queue.poll().value);
        assertEquals("task1", queue.poll().value);
        assertEquals("task2", queue.poll().value);
        assertEquals("task3", queue.poll().value);
        assertEquals("task5", queue.poll().value);
    }
}
