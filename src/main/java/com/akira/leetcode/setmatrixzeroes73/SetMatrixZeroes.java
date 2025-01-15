package com.akira.leetcode.setmatrixzeroes73;

import com.akira.leetcode.util.ArrayUtil;

/**
 * @projectName: javaDemo
 * @package: com.akira.leetcode.setmatrixzeroes73
 * @className: SetMatrixZeroes
 * @author: tzk
 * @description: TODO
 * @date: 2025/1/15 17:02
 * @version: 1.0
 */
public class SetMatrixZeroes {
    public static void launch() {
        SetMatrixZeroes solution = new SetMatrixZeroes();
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        solution.setZeroes(matrix);
        ArrayUtil.traverseTwoDimensionalArray(matrix);
    }

    private void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
