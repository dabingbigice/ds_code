package com.example._2024_11;


public class _34在排序数组中查找元素的第一个和最后一个位置 {
    /*
    示例 1：

输入：nums = [5,7,7,8,8,10], target = 8
输出：[3,4]
示例 2：

输入：nums = [5,7,7,8,8,10], target = 6
输出：[-1,-1]
示例 3：

输入：nums = [], target = 0
输出：[-1,-1]
     */
    public static int[] searchRange(int[] nums, int target) {
        int i = 0, j = nums.length - 1, m = (i + j) >>> 1;
        int r[] = {-1, -1};
        r[0]=left(nums,target);
        r[1]=right(nums,target);
        return r;
    }

    public static int left(int[] arr, int target) {
        int i = 0, j = arr.length - 1, m = (i + j) >>> 1;
        int c=-1;
        while (i <= j) {
            if (arr[m] < target) {
                i = m + 1;
            }
            if (target<arr[m] ) {
                j = m - 1;
            }
            if (arr[m]==target){ c=m;
                //发现了相同的元素，记录下来，并往左走
                j=m-1;

            }
            m = (i + j) >>> 1;
        }

        return c;
    }

    public static int right(int[] arr, int target) {
        int i = 0, j = arr.length - 1, m = (i + j) >>> 1;
        int c =-1;
        while (i <= j) {
            if (target < arr[m]) {
                j = m - 1;
            }
            if (arr[m]<target){
                    i = m + 1;
            }
            if (arr[m]==target){ c=m;
                //发现了相同的元素，记录下来，并往右走

                i=m+1;

            }
            m = (i + j) >>> 1;
        }

        return  c;
    }

    public static void main(String[] args) {
        // 5(i), 7, 7, 8(m), 8, 10(j)
        int[] ints = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
        System.out.println(ints);
    }
}
