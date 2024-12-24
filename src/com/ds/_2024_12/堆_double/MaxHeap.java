package com.ds._2024_12.堆_double;

import java.util.Arrays;

/**
 * 大顶堆
 * 1.找到非叶子节点
 * 2.从后向前，执行下潜。找儿子大的那个
 */
public class MaxHeap {
    int[] array;
    int size;

    public MaxHeap(int capacity) {
        this.array = new int[capacity];
    }

    /**
     * 获取堆顶元素
     *
     * @return 堆顶元素
     */
    public int peek() {
        return array[0];
    }

    /**
     * 删除堆顶元素
     *
     * @return 堆顶元素
     */
    public int poll() {
        //先root与最后一个元素交换
        //然后删除最后一个
        //然后用parent去调整堆
        int top = array[0];
        swap(0, size - 1);
        size--;
        down(0);
        return top;
    }

    /**
     * 删除指定索引处元素
     *
     * @param index 索引
     * @return 被删除元素
     */
    public int poll(int index) {
        int val = array[index];
        swap(index, size - 1);
        size--;
        down(index);
        return -1;
    }

    /**
     * 替换堆顶元素
     *
     * @param replaced 新元素
     */
    public void replace(int replaced) {
        array[0] = replaced;
        down(0);
    }

    /**
     * 堆的尾部添加元素
     *
     * @param offered 新元素
     * @return 是否添加成功
     */
    public boolean offer(int offered) {
        if (size == array.length) return false;
        up(offered);
        size++;
        return true;
    }

    // 将 offered 元素上浮: 直至 offered 小于父元素或到堆顶
    private void up(int offered) {
        int child = size;
        while (child > 0) {
            int parent = (child - 1) / 2;
            if (array[parent] < offered) {
                //比较parent与offered的大小，如果parent小，那么就需要下移，如果parent大，那么直接结束循环
                //parent下移
                array[child] = array[parent];
            } else {
                break;
            }
            child = parent;
        }
        //最后插入offered，找到插入的位置了
        array[child] = offered;
    }

    public MaxHeap(int[] array) {
        this.array = array;
        this.size = array.length;
        heapify();
    }

    // 建堆.从尾部元素开始
    private void heapify() {
        //从最后一个非叶子节点开始调整
        for (int i = size / 2 - 1; i >= 0; i--) {
            down(i);
            new String("aaa");
            new StringBuilder().toString();
        }

    }

    // 将 parent 索引处的元素下潜: 与两个孩子较大者交换, 直至没孩子或孩子没它大
    private void down(int parent) {
        //用父亲节点找孩子节点
        int left = parent * 2 + 1;
        int right = left + 1;
        int max = parent;
        if (left < size && array[max] < array[left]) {
            max = left;
        }
        if (right < size && array[max] < array[right]) {
            max = right;
        }
        if (parent != max) {
            swap(max, parent);
            down(max);
        }
    }

    // 交换两个索引处的元素
    private void swap(int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public static void main(String[] args) {

        int[] array = {2, 3, 1, 7, 6, 4, 5};
        MaxHeap heap = new MaxHeap(array);
        System.out.println(Arrays.toString(heap.array));
        //用大顶堆去构造小顶堆
        while (heap.size > 1) {
            //将最后一个元素删除到堆的最末尾
            //然后进行大顶堆的从新建立
            heap.swap(0, heap.size - 1);
            heap.size--;
            heap.down(0);
        }

        System.out.println(Arrays.toString(heap.array));
    }
}
