package com.ds._2024_12.队列;

public class _622_设计循环队列 {
    int queue[];
    int front;
    int last;


    //MyCircularQueue(k): 构造器，设置队列长度为 k 。
    //Front: 从队首获取元素。如果队列为空，返回 -1 。
    //Rear: 获取队尾元素。如果队列为空，返回 -1 。
    //enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
    //deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
    //isEmpty(): 检查循环队列是否为空。
    //isFull(): 检查循环队列是否已满。
    public _622_设计循环队列(int k) {
        queue = new int[k + 1];
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        queue[last] = value;
        last = (last + 1) % queue.length;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        front = (front + 1) % queue.length;
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return queue[front];
    }

    public int Rear() {
        if (isEmpty()) return -1;
        if (last == 0) {
            return queue[queue.length-1];
        }
        return queue[last-1];
    }

    public boolean isEmpty() {
        return last == front;
    }

    public boolean isFull() {
        return front == (last + 1) % queue.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */