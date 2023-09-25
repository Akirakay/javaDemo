package com.akira.leetcode.binarysearch704;

public class BinarySearch {
    public static void launch() {
        BinarySearch solution = new BinarySearch();
        int search = solution.search(new int[]{-1, 0, 3, 5, 9, 12}, 2);
        System.out.println(search);
    }

    public int search(int[] nums, int target) {
        int right = nums.length - 1;
        int left = 0;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
