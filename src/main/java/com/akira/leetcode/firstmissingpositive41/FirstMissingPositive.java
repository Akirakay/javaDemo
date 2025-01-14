package com.akira.leetcode.firstmissingpositive41;

/**
 * @projectName: javaDemo
 * @package: com.akira.leetcode.firstmissingpositive41
 * @className: FirstMissingPositive
 * @author: tzk
 * @description: TODO
 * @date: 2025/1/14 11:23
 * @version: 1.0
 */
public class FirstMissingPositive {
    public static void launch() {
        FirstMissingPositive solution = new FirstMissingPositive();
        int[] nums = {3,4,-1,1};
//        int[] nums = {1, 2, 0};
//        int[] nums = {7, 8, 9, 11, 12};
        System.out.println(solution.firstMissingPositive(nums));
    }

    /**
     * 原地hash法
     * <a href='https://leetcode.cn/problems/first-missing-positive/solutions/7703/tong-pai-xu-python-dai-ma-by-liweiwei1419/?envType=study-plan-v2&envId=top-100-liked' />
     * @param nums
     * @return int
     * @author Ak1ra
     * @date 2025/1/14 11:24
     * @description
     */
    private int firstMissingPositive(int[] nums) {
        // 原地hash法,把元素i放入下标i-1的位置
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] >= 1 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
