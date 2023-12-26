package com.akira.leetcode.removeduplicatesfromsortedarrayii80;


public class RemoveDuplicatesFromSortedArrayII {
    public static void launch() {
        RemoveDuplicatesFromSortedArrayII solution = new RemoveDuplicatesFromSortedArrayII();
        int[] arr = new int[]{1,1,1,2,2,3};
        int num = solution.removeDuplicates(arr);
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
}
