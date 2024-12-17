package com.example._2024_12.栈;

import java.util.LinkedList;

public class _225_用队列实现栈 {

    //用两个队列实现栈
    //先将新的push元素放到s1，然后把所有s2的元素放到s1。然后再将所有s1的元素移动到s2。
    //只有当需要出栈的时候再去头队列pop一个
    LinkedList<Integer> s1 = new LinkedList<>();//头
    LinkedList<Integer> s2 = new LinkedList<>();//尾

    public void push(int x) {
        s1.push(x);
        while (!s2.isEmpty()) s1.push(s2.poll());
        while (!s1.isEmpty()) s2.push(s1.poll());

    }

    public int pop() {
        return s2.pop();
    }

    public int top() {

        return s2.peek();
    }

    public boolean empty() {

        return s1.isEmpty() && s2.isEmpty();
    }
}
