package com.akira.leetcode.climbingstairs70;

public class ClimbingStairs {

    public static void launch() {
        ClimbingStairs solution = new ClimbingStairs();
        int i = solution.climbStairs(3);
        System.out.println(i);
    }

    // 动态规划解法
    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // 斐波那契数
    public int climbStairsFib(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int prev1 = 1;
        int prev2 = 2;
        int curr = 0;
        for (int i = 3; i <= n; i++) {
            curr = prev1 + prev2;
            prev1 = prev2;
            prev2 = curr;
        }
        return curr;
    }
}
