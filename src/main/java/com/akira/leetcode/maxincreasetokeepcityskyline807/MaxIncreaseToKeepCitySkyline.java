package com.akira.leetcode.maxincreasetokeepcityskyline807;

public class MaxIncreaseToKeepCitySkyline {
    public static void launch() {
        MaxIncreaseToKeepCitySkyline solution = new MaxIncreaseToKeepCitySkyline();
        int [][] grid = new int[][]{{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
        int increase = solution.maxIncreaseKeepingSkyline(grid);
        System.out.println(increase);
    }

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[] rowMax = new int[n];
        int[] colMax = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowMax[i] = Math.max(rowMax[i], grid[i][j]);
                colMax[j] = Math.max(colMax[j], grid[i][j]);
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans += Math.min(rowMax[i], colMax[j]) - grid[i][j];
            }
        }
        return ans;
    }
}
