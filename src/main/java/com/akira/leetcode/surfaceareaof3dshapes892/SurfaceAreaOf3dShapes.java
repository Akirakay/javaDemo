package com.akira.leetcode.surfaceareaof3dshapes892;

/**
 * @projectName: javaDemo
 * @package: com.akira.leetcode.surfaceareaof3dshapes892
 * @className: SurfaceAreaOf3dShapes
 * @author: tzk
 * @description: TODO
 * @date: 2024/9/3 14:45
 * @version: 1.0
 */
public class SurfaceAreaOf3dShapes {
    public static void launch() {
        int[][] grid = {{1, 2}, {3, 4}};
        SurfaceAreaOf3dShapes solution = new SurfaceAreaOf3dShapes();
        System.out.println(solution.surfaceArea(grid));
    }

    private int surfaceArea(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] > 0) ans += 2 + grid[i][j] * 4;
                if (i > 0) ans -= Math.min(grid[i][j], grid[i - 1][j]) * 2;
                if (j > 0) ans -= Math.min(grid[i][j], grid[i][j - 1]) * 2;
            }
        }
        return ans;
    }
}
