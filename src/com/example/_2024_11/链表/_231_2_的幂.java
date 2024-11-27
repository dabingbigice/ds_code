package com.example._2024_11.链表;

public class _231_2_的幂 {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        if (n == 1) return true;
        if (n % 2 != 0) return false;
        if (n / 2 == 1) return true;
        return isPowerOfTwo(n / 2);
    }
}
