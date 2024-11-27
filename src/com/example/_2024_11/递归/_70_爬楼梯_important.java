package com.example._2024_11.递归;

public class _70_爬楼梯_important {
    /**
     * '
     * n=1 ,1
     * n=2 ,2
     * n=3 ,3
     * n=4  ,5
     * 1,1,1,1
     * 1,2,1
     * 1,1,2
     * 2,1,1
     * 2,2
     * n=5 ,8
     * 1,1,1,1,1
     * 1,2,1,1
     * 1,1,1,2
     * 1,2,2
     * 2,1,1
     * 2,2,1
     * 1,1,2,1
     * 2,1,1,1
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        int cache[] = new int[n + 1];
        cache[1] = 1;
        cache[2] = 2;
        return cache(n, cache);
    }

    private static int cache(int n, int arr[]) {
        if (n == 0 || n == 1 || n == 2) return n;
        if (arr[n] != 0) {
            //如果缓存中有，就直接返回
            return arr[n];
        }
        int x = cache(n - 1, arr);
        int y = cache(n - 2, arr);
        //缓存没有，将值放入缓存
        arr[n] = x + y;//f(n-1)+f(n-2)
        return arr[n];
    }

    public static int climbStairs1(int n) {
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 2;
        return cache1(n, arr);
    }

    private static int cache1(int n, int arr[]) {
        if (n == 0 || n == 1 || n == 2) return n;
        if (arr[n] != 0) {
            //缓存有数据
            return arr[n];
        }
        //缓存没有数据
        int x = cache1(n - 1, arr);
        int y = cache1(n - 2, arr);
        arr[n] = x + y;
        return arr[n];

    }

    public static void main(String[] args) {
        climbStairs(45);
    }
}
