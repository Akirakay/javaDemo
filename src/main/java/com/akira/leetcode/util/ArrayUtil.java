package com.akira.leetcode.util;

/**
 * @projectName: javaDemo
 * @package: com.akira.leetcode.util
 * @className: ArrayUtil
 * @author: tzk
 * @description: TODO
 * @date: 2024/9/11 16:18
 * @version: 1.0
 */
public class ArrayUtil {

    public static void traverseOneDimensionalArray(int[] array) {
        if (array == null) {
            return;
        }
        for (int ele : array) {
            System.out.print(ele + " ");
        }
    }

    public static void traverseTwoDimensionalArray(int[][] array) {
        if (array == null) {
            return;
        }
        for (int[] arr : array) {
            // 对于每一行，再次遍历其所有元素
            for (int i : arr) {
                System.out.print(i + " ");
            }
            // 每一行遍历完成后换行
            System.out.println();
        }
    }
}
