package com.akira.leetcode.partitionequalsubsetsum416;

/**
 * @projectName: javaDemo
 * @package: com.akira.leetcode.partitionequalsubsetsum416
 * @className: PartitionEqualSubsetSum
 * @author: tzk
 * @description: TODO
 * @date: 2025/1/3 10:59
 * @version: 1.0
 */
public class PartitionEqualSubsetSum {
    public static void launch() {
        PartitionEqualSubsetSum solution = new PartitionEqualSubsetSum();
//        int[] nums = new int[]{1, 5, 11, 5};
        int[] nums = new int[]{1, 2, 3, 5};
        boolean canPartition = solution.canPartition(nums);
        System.out.println(canPartition);
    }

    /**
     * <a href='https://leetcode.cn/problems/partition-equal-subset-sum/solutions/442320/fen-ge-deng-he-zi-ji-by-leetcode-solution/' />
     * @param nums
     * @return boolean
     * @author Ak1ra
     * @date 2025/1/3 11:00
     * @description
     */
    private boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            for (int j = target; j >= num; --j) {
                dp[j] |= dp[j - num];
            }
        }
        return dp[target];
    }
}
