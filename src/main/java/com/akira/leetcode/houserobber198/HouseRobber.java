package com.akira.leetcode.houserobber198;

/**
 * @projectName: javaDemo
 * @package: com.akira.leetcode.houserobber198
 * @className: HouseRobber
 * @author: tzk
 * @description: TODO
 * @date: 2024/12/3 13:46
 * @version: 1.0
 */
public class HouseRobber {
    public static void launch() {
        HouseRobber solution = new HouseRobber();
        int[] nums = {1, 2, 3, 1};
        int rob = solution.robOptimize(nums);
        System.out.println(rob);
    }

    /**
     * 198. 打家劫舍
     * <a href="https://leetcode.cn/problems/house-robber/solutions/263856/da-jia-jie-she-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked"/>
     * @param nums
     * @return int
     * @author tzk
     * @date 2024/12/3 13:58
     * @description
     */
    private int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }

    /**
     * 虑到每间房屋的最高总金额只和该房屋的前两间房屋的最高总金额相关，因此可以使用滚动数组，在每个时刻只需要存储前两间房屋的最高总金额
     * @param nums
     * @return
     */
    public int robOptimize(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }
}
