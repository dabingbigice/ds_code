package com.ds._2024_12.栈;

import java.util.Stack;

public class _20_有效的括号 {

    /**
     * 创建一个栈，
     * 每次去string中获取一个字符，如果是左括号，那么就像stack中添加一个期待的右括号
     * 如果是右括号，那么就去栈中弹出一个数据，看是否与当前的右括号相等，如果相等那就是相同的
     * 如果不等就不是
     * 因为stack中存储的都是期待的右括号
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s.length() == 0 || s.length() == 1) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '(') {
                stack.push(')');
            } else {
                if (!stack.isEmpty() && stack.peek() == c) {
                    stack.pop();
                } else {
                    //如果第一个是右括号进来
                    return false;
                }
                //当前是左括号
            }

        }
        return stack.isEmpty();
    }
}
