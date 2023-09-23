package com.akira.leetcode.mergesortedarray88;

public class MergeSortedArray {
    public static void launch() {
        MergeSortedArray solution = new MergeSortedArray();
        int[] nums1 = new int[]{0};
        int m = 0;
        int[] nums2 = new int[]{1};
        int n = 1;
        solution.merge(nums1, m, nums2, n);
        for (int i : nums1) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // 如果是需要去重 该如何处理
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        int size = m + n;
        while (m > 0 && n > 0) {
            if (nums1[m - 1] <= nums2[n - 1]) {
                nums1[--size] = nums2[--n];
            } else {
                nums1[--size] = nums1[--m];
            }
        }
        while (n > 0) {
            nums1[--size] = nums2[--n];
        }
    }
}
