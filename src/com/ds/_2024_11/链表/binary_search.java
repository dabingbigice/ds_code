package com.ds._2024_11.链表;

public class binary_search {
    /**
     * 除法用移位操作。比较符号小的放小的那一边
     * @param a
     * @param target
     * @return
     */
    public static int func(int[] a, int target) {

        int index_i = 0;
        int index_j = a.length - 1;
        int index_m = (index_j + index_i) >> 1;
        while (index_i <= index_j) {
            //=因为当 i= m = j 的时候有可能正好是目标值
            if (a[index_m] == target) {
                return index_m;
            }
            if (target < index_m) {
                index_j = index_m - 1;
            }
            if (index_m < target) {
                index_i = index_m + 1;
            }
            index_m = (index_j + index_i) >> 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(func(new int[]{1, 3, 6, 10, 10, 12}, 10));//1
    }
}

