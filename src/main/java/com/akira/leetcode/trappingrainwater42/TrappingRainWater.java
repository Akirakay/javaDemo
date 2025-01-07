package com.akira.leetcode.trappingrainwater42;

/**
 * @projectName: javaDemo
 * @package: com.akira.leetcode.trappingrainwater42
 * @className: TrappingRainWater
 * @author: tzk
 * @description: TODO
 * @date: 2025/1/7 11:31
 * @version: 1.0
 */
public class TrappingRainWater {
    public static void launch() {
        TrappingRainWater solution = new TrappingRainWater();
//        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] height = {4, 2, 3};
        int length = solution.trap(height);
        System.out.println(length);
    }

    /**
     *
     * <a href="https://leetcode.cn/problems/trapping-rain-water/solutions/692342/jie-yu-shui-by-leetcode-solution-tuvc/?envType=study-plan-v2&envId=top-100-liked" />
     * @param height
     * @return int
     * @author Ak1ra
     * @date 2025/1/7 11:32
     * @description
     */
    private int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }

        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; ++i) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }
}
