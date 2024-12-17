package com.example._2024_12.栈;

import java.util.LinkedList;

public class _225_用队列实现栈_1 {
    //只用一个队列
    LinkedList<Integer> s1 = new LinkedList<>();//头
    int size = 0;

    public void push(int x) {
        s1.offer(x);
        //然后poll出size个元素放到offer里面
        for (int i = 0; i < size; i++) {
            s1.offer(s1.poll());
        }
        size++;

    }
    public int pop() {
        size--;
        return s1.poll();
    }

    public int top() {

        return s1.peek();
    }

    public boolean empty() {

        return s1.isEmpty();
    }
}
