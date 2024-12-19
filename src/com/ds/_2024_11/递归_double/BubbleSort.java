package com.ds._2024_11.递归_double;

public class BubbleSort {


    private static void bubble(int arr[], int k) {
        //递的终止条件
        if (k == 0) return;
        int flag = -1;
        //内层循环完毕
        for (int i = 0; i < k; i++) {
            if (arr[i + 1] < arr[i]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
                flag = 0;
            }
        }
        if (flag == -1) return;
        //递，进行外层的循环
        bubble(arr, k - 1);
        //归
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1, 3, 5};
        bubble(arr, arr.length - 1);
    }
}
