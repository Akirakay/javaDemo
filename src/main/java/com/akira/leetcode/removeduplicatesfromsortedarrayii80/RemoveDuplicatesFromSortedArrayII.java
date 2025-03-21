package com.akira.leetcode.removeduplicatesfromsortedarrayii80;


public class RemoveDuplicatesFromSortedArrayII {
    public static void launch() {
        RemoveDuplicatesFromSortedArrayII solution = new RemoveDuplicatesFromSortedArrayII();
        int[] arr = new int[]{1,1,1,2,2,3};
        int num = solution.removeDuplicatesUsingSort(arr);
        for (int i = 0; i < num; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int slow = 2, fast = 2;
        while (fast < n) {
            // this is key point
            // if nums[slow - 2] = nums[fast], then nums[slow - 2] = nums[slow - 1] = nums[fast]  total count > 2
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }

    /**
     * 牛人思路：直接利用排序的特性，如果当前元素大于前两个元素，则保留当前元素，否则跳过当前元素 i是数据应该存放的下标
     * @param nums
     * @return int
     * @author Ak1ra
     * @date 2025/3/15 13:17
     * @description
     */
    public int removeDuplicatesUsingSort(int[] nums) {
        int i = 0;
        for (int num : nums) {
            if (i < 2 || num > nums[i - 2]) {
                nums[i++] = num;
            }
        }

        return i;
    }
}
