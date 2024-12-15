package com.example._2024_11.链表;

import java.util.Arrays;

/*
给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，
其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
示例 1：
输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
输出：[1,2,2,3,5,6]
解释：需要合并 [1,2,3] 和 [2,5,6] 。
合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
示例 2：
输入：nums1 = [1], m = 1, nums2 = [], n = 0
输出：[1]
解释：需要合并 [1] 和 [] 。
合并结果是 [1] 。
示例 3：
输入：nums1 = [0], m = 0, nums2 = [1], n = 1
输出：[1]
解释：需要合并的数组是 [] 和 [1] 。
合并结果是 [1] 。
注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
 */
public class _88合并两个有序数组 {
    /**
     * 从后往前移动
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = nums1.length - 1;//指向需要修改的那个元素
        //从后往前比较大的元素，把大的放到现有数组的最后，但是i中会存在重复数据，后面需要用j中的数据覆盖。如果i已经比较完了。那么把j的数据全部放进去
        while (i >= 0 && j >= 0) {
            //一直比较
            if (nums1[i] < nums2[j]) {
                nums1[k] = nums2[j];
                j--;
            } else {
                nums1[k] = nums1[i];
                i--;
            }
            k--;
        }
        //如果i>0，那么表面J已经全部放进去了。而j>0表明还没合并剩下的元素。
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }

    }

    /**
     * 赋值完成后进行拷贝再排序
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int max = m + n - 1;
        int k = 0;
        while (m <= max & k < n) {
            nums1[m++] = nums2[k++];
        }
        Arrays.sort(nums1);

    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int index = nums1.length - 1;
        int p1 = m - 1;
        int p2 = n - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] < nums2[p2]) {
                nums1[index] = nums2[p2];
                index--;
                p2--;
            } else {
                nums1[index] = nums1[p1];
                index--;
                p1--;
            }
        }
        while (p2 >= 0) {
            nums1[index] = nums2[p2];
            index--;
            p2--;
        }

    }

    public static void main(String[] args) {
        int nums1[] = new int[]{0, 0, 0, 0, 0};
        int nums2[] = new int[]{1, 2, 3, 4, 5};
        merge(nums1, 0, nums2, 5);


    }
}
