package com.akira.leetcode.maximumproductsubarray152;

/**
 * @projectName: javaDemo
 * @package: com.akira.leetcode.maximumproductsubarray152
 * @className: MaximumProductSubarray
 * @author: tzk
 * @description: TODO
 * @date: 2025/1/2 13:53
 * @version: 1.0
 */
public class MaximumProductSubarray {
    public static void launch() {
        MaximumProductSubarray solution = new MaximumProductSubarray();
        int[] nums = {2, 3, -2, 4};
        System.out.println(solution.maxProduct(nums));
    }

    /**
     * 因为负负得正的性质，转移方程不能是简单的最优子结构
     * <a href="https://leetcode.cn/problems/maximum-product-subarray/solutions/250015/cheng-ji-zui-da-zi-shu-zu-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked" />
     * @param nums
     * @return int
     * @author tzk
     * @date 2025/1/2 13:54
     * @description
     */
    private int maxProduct(int[] nums) {
        int length = nums.length;
        long[] maxF = new long[length];
        long[] minF = new long[length];
        for (int i = 0; i < length; i++) {
            maxF[i] = nums[i];
            minF[i] = nums[i];
        }
        for (int i = 1; i < length; ++i) {
            maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
            minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(nums[i], maxF[i - 1] * nums[i]));
            if (minF[i] < (-1 << 31)) {
                minF[i] = nums[i];
            }
        }
        int ans = (int) maxF[0];
        for (int i = 1; i < length; ++i) {
            ans = Math.max(ans, (int) maxF[i]);
        }
        return ans;
    }
}
