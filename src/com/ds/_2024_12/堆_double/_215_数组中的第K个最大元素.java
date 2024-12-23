package com.ds._2024_12.堆_double;

public class _215_数组中的第K个最大元素 {
    //进行k轮大顶堆排序,获取前k个。从尾部开始



    private void swap(int[] nums, int max, int parent) {
        int temp = nums[max];
        nums[max] = nums[parent];
        nums[parent] = temp;

    }

    public static void main(String[] args) {
        int[] array = {3,2,3,1,2,4,5,5,6};
        _215_数组中的第K个最大元素 test = new _215_数组中的第K个最大元素();

    }
}
