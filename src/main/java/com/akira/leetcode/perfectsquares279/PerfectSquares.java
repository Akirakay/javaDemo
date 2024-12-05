package com.akira.leetcode.perfectsquares279;

import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: javaDemo
 * @package: com.akira.leetcode.perfectsquares279
 * @className: PerfectSquares
 * @author: tzk
 * @description: TODO
 * @date: 2024/12/5 13:50
 * @version: 1.0
 */
public class PerfectSquares {
    public static void launch() {
        PerfectSquares solution = new PerfectSquares();
        int length = solution.numSquaresPackage(12);
        System.out.println(length);
    }

    /**
     * 动态转移方程：f[i] = min(f[i], f[i - j * j] + 1)
     * @param n
     * @return int
     * @author tzk
     * @date 2024/12/5 13:50
     * @description
     */
    private int numSquares(int n) {
        int[] f = new int[n + 1];
        f[0] = 0;
        for (int i = 1; i <= n; i++) {
            f[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                f[i] = Math.min(f[i - j * j] + 1, f[i]);
            }
        }
        return f[n];
    }

    /**
     * 完全背包方式 (相关概念：01背包方式)
     * @param n
     * @return int
     * @author tzk
     * @date 2024/12/5 13:50
     * @description
     */
    private int numSquaresPackage(int n) {
        //完全背包问题，物品为1,4,9,……所有小于等于根号n的完全平方数
        //最理想情况下n就是完全平方数，n=(根号n)^2 + 0
        return numSquaresPackageDetail(n);
    }
    private int numSquaresPackageDetail(int n) {
        //物品数组，所有小于等于n的完全平方数
        List<Integer> nums = new ArrayList<Integer>();
        int num = 1;
        while(num*num<=n){
            nums.add(num*num);
            num+=1;
        }
        int m = nums.size();//物品数量
        //dp[i][j]，在0到i个物品中选取，最少需要几个完全平方数表示j
        //放不下：dp[i][j]=dp[i-1][j]
        //放得下，选两种情况中更少的：放dp[i][j]=dp[i][j-nums[i]]+1，不放dp[i][j]=dp[i-1][j]
        int[][] dp = new int[m][n+1];
        for(int j=0;j<=n;j++){//初始化，只用物品0的情况
            if(j%nums.get(0)==0) dp[0][j] = j/nums.get(0);//整除nums[0]时，可以组成
        }
        for(int i=1;i<m;i++){
            for(int j=0;j<=n;j++){
                if(j<nums.get(i)) dp[i][j] = dp[i-1][j];//放不下，继承
                else{//放得下，取不放和放中，更小的。dp[i][j-nums.get(i)]是因为可以重复选取
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-nums.get(i)]+1);
                }
            }
        }
        return dp[m-1][n];
    }
}
