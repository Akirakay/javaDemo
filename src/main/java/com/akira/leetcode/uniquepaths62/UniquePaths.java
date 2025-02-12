package com.akira.leetcode.uniquepaths62;

/**
 * @projectName: javaDemo
 * @package: com.akira.leetcode.uniquepaths62
 * @className: UniquePaths
 * @author: tzk
 * @description: TODO
 * @date: 2025/2/12 10:28
 * @version: 1.0
 */
public class UniquePaths {
    public static void launch() {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePathsExt(3, 7));
    }

    private int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        // 初始化第一行
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        // 初始化第一列
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 优化空间 dp[i][j] = dp[i-1][j] + dp[i][j-1] 可以优化空间，只用一维数组
     * 只与i行和i-1行有关 可以使用滚动数组来优化
     * @param m
     * @param n
     * @return int
     * @author Ak1ra
     * @date 2025/2/12 10:38
     * @description
     */
    public int uniquePathsExt(int m, int n) {
        int[] f = new int[n];
        for (int i = 0; i < n; ++i) {
            f[i] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                f[j] += f[j - 1];
            }
        }
        return f[n - 1];
    }
}
