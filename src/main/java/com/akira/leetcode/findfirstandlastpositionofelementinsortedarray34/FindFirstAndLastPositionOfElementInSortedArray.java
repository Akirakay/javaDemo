package com.akira.leetcode.findfirstandlastpositionofelementinsortedarray34;


/**
 * source:
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/solutions/504484/zai-pai-xu-shu-zu-zhong-cha-zhao-yuan-su-de-di-3-4/comments/1989894
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void launch() {
        FindFirstAndLastPositionOfElementInSortedArray solution = new FindFirstAndLastPositionOfElementInSortedArray();
//        int[] arr = solution.searchRange(new int[]{1, 3, 4, 5, 8, 8, 9}, 8);
        int[] arr = solution.searchRange(new int[]{2, 2}, 2);
        System.out.println(arr[0] + " " + arr[1]);
    }

    public int[] searchRange(int[] nums, int target) {
        int first = -1;
        int second = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                first = mid;
                right = mid - 1; // !!!关键点
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                second = mid;
                left = mid + 1; //!!!关键点
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return new int[]{first, second};
    }

}
