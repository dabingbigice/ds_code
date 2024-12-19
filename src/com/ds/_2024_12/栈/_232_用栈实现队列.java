package com.ds._2024_12.栈;

import java.util.Stack;

public class _232_用栈实现队列 {
    //头栈
    Stack<Integer> s1 = new Stack<>();
    //尾栈
    Stack<Integer> s2 = new Stack<>();

    public void push(int x) {
        s2.push(x);
    }

    //从头栈中弹出一个元素，如果头栈为空，那么要移动所有元素到头栈中。
    //移动后不需要再管了，因为队列只需要弹出头部元素即可
    public int pop() {
        if (s1.isEmpty()) {
            //当头栈没有数据时

            while (!s2.isEmpty()) s1.push(s2.pop());
        }
        return s1.pop();
    }

    public int peek() {
        if (s1.isEmpty()) {
            //当头栈没有数据时
            while (!s2.isEmpty()) s1.push(s2.pop());

        }
        return s1.peek();
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
