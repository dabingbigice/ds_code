package com.ds._2024_11.递归_double;

public class InsertSort {
    /**
     * 插入排序的核心思想：选择一个合适的索引插入
     *
     * @param arr
     * @param low
     */
    public static void insertion(int arr[], int low) {
        //递的结束，进行归操作
        if (arr.length == low) return;
        int temp = arr[low];
        int i = low;
        while (i > 0 && temp < arr[i - 1]) {
            //用前一个覆盖后一个，i是多余出来的那个索引，可以直接覆盖操作。
            arr[i] = arr[i - 1];
            i--;
        }
        //最终覆盖需要插入的位置
        arr[i] = temp;
        insertion(arr, low + 1);


        //归
    }

    /**
     * for循环实现
     *
     * @param arr
     */
    public static void insertion(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > temp) {
                //如果当前索引的值大于当前需要插入的值
                arr[j] = arr[j - 1];
                //指针前移，继续判断
                j--;
            }
            //如果不需要替换就替换自己
            arr[j] = temp;
        }
    }


    public static void insertion1(int arr[]) {
        //如果当前指针的值大于需要排序的值，那么把当前指针的值覆盖后一个指针的值
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;//待插入的位置
            while (j > 0 && arr[j - 1] > temp) {
                //比较待插入的位置和前一个位置的大小值
                //覆盖
                arr[j] = arr[j - 1];
                j--;
            }
            //跳出循环，证明当前j指针的值是需要替换的值
            arr[j] = temp;

        }
    }

    public static void insertion2(int arr[]) {
        //交换
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                //swap
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
        }
    }

    public static void insertion3(int arr[]) {
        //赋值
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;

        }
    }

    public static void insertion4(int arr[]) {
        //获取待排序的值
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];//待排序的值
            int j = i;//获取当前待排序的索引
            //比较当前元素与前一个元素的值大小
            while (j > 0 && temp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            //找到替换的位置了，进行替换
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[]{2, 4, 5, 10, 7, 1};
        // insertion(arr, 1);
        insertion4(arr);
    }
}
