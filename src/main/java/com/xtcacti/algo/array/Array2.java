package com.xtcacti.algo.array;

import java.util.Arrays;

/**
 * @ClassName MyThreeArray
 * @Description TODO:3 - 实现两个有序数组合并为一个有序数组 | 类型为int
 * @Author 15735
 * @Date 2021/3/25 22:56
 * @Version 1.0
 */
public class Array2 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 3, 5};
        int[] arr2 = new int[]{2, 4, 6};
        int[] merge = merge(arr1, arr2);
        System.out.println(Arrays.toString(merge));
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int i = 0, j = 0, z = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                result[z] = arr1[i];
                z++;
                i++;
                result[z] = arr2[j];
                z++;
                j++;
            }
        }
        while (i != arr1.length) {
            result[z] = arr1[i];
            i++;
            z++;
        }
        while (j != arr2.length) {
            result[z] = arr2[j];
            j++;
            z++;
        }
        return result;
    }
}
