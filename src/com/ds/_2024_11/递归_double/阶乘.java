package com.ds._2024_11.递归_double;

public class 阶乘 {
    public static int fn(int n) {
        if (n == 1) {
            //终止条件
            return n;
        }
        return fn(n - 1) * n;

    }

    public static void main(String[] args) {


        System.out.println(fn(3));


    }
}
