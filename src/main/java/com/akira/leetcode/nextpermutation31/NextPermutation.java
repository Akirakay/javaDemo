package com.akira.leetcode.nextpermutation31;

import com.akira.leetcode.util.ArrayUtil;

/**
 * @projectName: javaDemo
 * @package: com.akira.leetcode.nextpermutation31
 * @className: NextPermutation
 * @author: tzk
 * @description: TODO
 * @date: 2024/9/18 18:10
 * @version: 1.0
 */
public class NextPermutation {
    public static void launch() {
        NextPermutation solution = new NextPermutation();
        int[] nums = {1, 2, 3};
        solution.nextPermutation(nums);
        ArrayUtil.traverseOneDimensionalArray(nums);
    }

    /**
     * find out the next permutation of the given array
     * <a href = https://leetcode.cn/problems/next-permutation/solutions/479151/xia-yi-ge-pai-lie-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-like />
     * @param nums
     * @return void
     * @author tzk
     * @date 2024/9/18 18:32
     * @description
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
