package com.akira.leetcode.searcha2dmatrixii240;

/**
 * @projectName: javaDemo
 * @package: com.akira.leetcode.searcha2dmatrixii240
 * @className: SearchA2DMatrixII
 * @author: tzk
 * @description: TODO
 * @date: 2025/1/17 11:41
 * @version: 1.0
 */
public class SearchA2DMatrixII {
    public static void launch() {
        SearchA2DMatrixII solution = new SearchA2DMatrixII();
        Boolean flag = solution.searchMatrix(new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        }, 5);
        System.out.println(flag);
    }

    /**
     * 搜索二维矩阵 II
     * <a href='https://leetcode.cn/problems/search-a-2d-matrix-ii/solutions/1062538/sou-suo-er-wei-ju-zhen-ii-by-leetcode-so-9hcx/?envType=study-plan-v2&envId=top-100-liked' />
     * @param matrix
     * @param target
     * @return
     */
    private Boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            }
            if (matrix[x][y] > target) {
                --y;
            } else {
                ++x;
            }
        }
        return false;
    }
}
