package com.example._2024_11.递归;

public class Fibonacci {
    public static int f(int n) {
        if (n == 0 || n == 1) return n;

        return f(n-1) + f(n - 2);

    }

    public static void main(String[] args) {
        System.out.println(f(12));
    }
}
