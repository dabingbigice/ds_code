package com.ds._2024_11.递归_double;

public class ReversOutString {
    public static void f(String str, int n) {
        //归的条件，跳出来的条件,先打印当前数据
        if (str.length() == n) {
            //这样就是当长度超出了索引下标，那么直接结束递的操作，进行归的输出
            return;
        }
        //递的输出
        f(str, n + 1);
        //归的输出
        System.out.println(str.charAt(n));

    }

    public static void f1(String str, int n) {
        //n=str.length
        if (n<0){
            return;
        }
        //递的输出
        System.out.println(str.charAt(n));
        f1(str,n-1);
        //归的输出
    }

    public static void main(String[] args) {
        //f("hello", 0);
        f1("hello", 4);
    }
}
