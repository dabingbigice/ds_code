package com.example._2024_11.递归;

public class BinarySearch {
    public static int f(int a[], int target, int i, int j) {
        //递的终止条件
        if (i > j) {
            //归的返回值
            return -1;
        }

        int m = (i + j) >>> 1;
        if (a[m] < target) {
            f(a, target, m + 1, j);
        } else if (target < a[m]) {
            f(a, target, i, m - 1);
        } else {
            //归的返回值
            return m;
        }

        return -1;
    }

    public static void main(String[] args) {
        //如果递归又返回值，那么调用的时候一定要加return
        System.out.println(f(new int[]{1, 3, 5, 6, 8, 10}, 5, 0, 5));
    }
}
