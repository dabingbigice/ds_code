package _2024_11;

import sun.applet.Main;

import javax.print.Doc;

public class 二分查找 {

    public static int func(int[] a, int target) {

        int index_i=0;
        int index_j=a.length-1;
        int index_m = (index_j+index_i)/2;
        while (index_i<index_j){
            if (a[index_m]==target){
                return 1;
            }
            if (index_m>target){
                index_j=index_m-1;
            }
            if (index_m<target){
                index_i=index_m+1;
            }
            index_m = (index_j+index_i)/2;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(func(new int[]{1,3,6,9,10,12},10));
    }
}

