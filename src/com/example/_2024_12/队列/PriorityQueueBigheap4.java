package com.example._2024_12.队列;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PriorityQueueBigheap4<E extends Priority> implements Queue<E> {
    Priority[] priorities;
    int size;

    public PriorityQueueBigheap4(int capacity) {
        priorities = new Priority[capacity + 1];
        priorities[0] = null;
    }

    /**
     * 入队新元素，加到队尾。
     * 不断比较父亲与当前节点的只
     * 如果父亲节点大，则结束
     * 如果父亲节点小就需要将父亲节点下移
     *
     * @param value
     * @return
     */
    @Override
    public boolean offer(E value) {
        //第一个不放数据
        if (isFull()) return false;
        if (size == 0) {
            priorities[size + 1] = value;
            size++;
            return true;
        }
        int child = (size + 1);
        size++;
        //先插入到底部
        int parent = child / 2;
        while (child > 1 && priorities[parent].priority() < value.priority()) {
            //如果父亲的优先级小，将父亲下移到孩子节点
            priorities[child] = priorities[parent];
            child = parent;
            parent = child / 2;
        }
        priorities[child] = value;
        return true;
    }

    @Override
    public E poll() {
        //先交换堆顶元素，然后再去重新调整堆
        if (isEmpty()) return null;
        swap(1, size);
        Priority e = priorities[size];

        priorities[size--] = null;
        //调整堆
        down(1);
        return (E) e;
    }

    private void down(int parent) {
        int lef = parent * 2;
        int right = parent * 2 + 1;
        //获取高优先级的那个子元素
        int max = parent;
        if (lef <= size && priorities[max].priority() < priorities[lef].priority()) {
            max = lef;
        }
        if (right <= size && priorities[max].priority() < priorities[right].priority()) {
            max = right;
        }
        if (max != parent) {
            swap(max, parent);
            down(parent);
        }
    }

    public void swap(int i, int j) {
        Priority temp = priorities[i];
        priorities[i] = priorities[j];
        priorities[j] = temp;
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;
        return (E) priorities[1];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == priorities.length - 1;
    }

    public static void main(String[] args) {
        PriorityQueueBigheap4<Entry> queue = new PriorityQueueBigheap4<>(5);
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
