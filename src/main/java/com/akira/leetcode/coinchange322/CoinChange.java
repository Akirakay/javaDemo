package com.akira.leetcode.coinchange322;

/**
 * @projectName: javaDemo
 * @package: com.akira.leetcode.coinchange322
 * @className: CoinChange
 * @author: tzk
 * @description: TODO
 * @date: 2024/12/6 15:10
 * @version: 1.0
 */
public class CoinChange {
    public static void launch() {
        CoinChange solution = new CoinChange();
        int[] coins = {1, 2, 5};
        int i = solution.coinChange(coins, 0);
        System.out.println(i);
    }

    private int coinChange(int[] coins, int amount) {
//        if (amount == 0) {
//            return 0;
//        }
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != -1) {
                    min = Math.min(min, dp[i - coin] + 1);
                }
            }
            dp[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return dp[amount];
    }
}
