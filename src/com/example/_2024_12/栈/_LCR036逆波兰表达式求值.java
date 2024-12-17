package com.example._2024_12.栈;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class _LCR036逆波兰表达式求值 {
    //用1个栈去操作，一个栈存储数字，当碰到符号时，弹出栈中的两个数字做加法，然后再放入栈
    public static int evalRPN(String[] tokens) {
        //jvm数据流是基于栈进行运算的
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < tokens.length; i++) {
            String val = tokens[i];

            if (val.equals("+")) {
                //+法
                Integer right = stack.pop();
                Integer left = stack.pop();
                stack.push(left + right);

            } else if (val.equals("-")) {
                Integer right = stack.pop();
                Integer left = stack.pop();
                stack.push(left - right);

            } else if (val.equals("*")) {
                Integer right = stack.pop();
                Integer left = stack.pop();
                stack.push(left * right);
            } else if (val.equals("/")) {
                Integer right = stack.pop();
                Integer left = stack.pop();
                stack.push(left / right);
            } else {
                //数字
                int num = Integer.parseInt(val);
                stack.push(num);
            }

        }
        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    }
}
