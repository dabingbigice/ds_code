package com.ds._2024_12.队列_优先级队列_阻塞队列;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PriorityQueueBigheap4_难<E extends Priority> implements Queue<E> {
    Priority[] priorities;
    int size;

    public PriorityQueueBigheap4_难(int capacity) {
        priorities = new Priority[capacity];
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

    //儿子找父亲
    public boolean offer(E value) {
        //第一个不放数据
        if (isFull()) return false;
        //offer是用孩子去找父亲
        int child = size++;
        //size刚好是需要放入的那个索引
        int parent = (child - 1) / 2;
        //因为是从index是0开始的
        while (child > 0 && priorities[parent].priority() < value.priority()) {
            //如果parent小，那么把parent下移
            priorities[child] = priorities[parent];
            //再去寻找新的parent索引
            child = parent;
            parent = (child - 1) / 2;
        }
        priorities[child] = value;
        return true;
    }

    @Override
    public E poll() {
        //先交换堆顶元素，然后再去重新调整堆
        if (isEmpty()) return null;
        swap(0, size - 1);
        size--;
        Priority e = priorities[size];
        priorities[size]=null;
        down(0);
        return (E) e;
    }
    //父亲找儿子
    private void down(int parent) {
        //parent找child
        int left = parent * 2 + 1;
        int right = left + 1;
        int max = parent;
        //找到大的那一个节点，然后交换
        if (left < size && priorities[max].priority() < priorities[left].priority()) {
            max = left;
        }
        //因为已经更改过max的索引，所以如果left大的话。进入right去比较的时候会用left的索引，也就是大的那个。
        if (right < size && priorities[max].priority() < priorities[right].priority()) {
            max = right;
        }
        if (max != parent) {
            //max被调整过
            swap(max, parent);
            down(max);
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
        return (E) priorities[0];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == priorities.length;
    }

    public static void main(String[] args) {
        PriorityQueueBigheap4_难<Entry> queue = new PriorityQueueBigheap4_难<>(5);
        queue.offer(new Entry("task1", 4));
        queue.offer(new Entry("task2", 3));
        queue.offer(new Entry("task3", 2));
        queue.offer(new Entry("task4", 5));
        queue.offer(new Entry("task5", 1));
        assertFalse(queue.offer(new Entry("task6", 7)));

        assertEquals(5, queue.peek().priority());
        assertEquals(5, queue.poll().priority());
        assertEquals(4, queue.poll().priority());
        assertEquals(3, queue.poll().priority());
        assertEquals(2, queue.poll().priority());
        assertEquals(1, queue.poll().priority());
    }
}
