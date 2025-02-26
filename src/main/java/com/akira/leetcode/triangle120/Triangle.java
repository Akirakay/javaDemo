package com.akira.leetcode.triangle120;

import com.akira.leetcode.util.ArrayUtil;

import java.util.List;

/**
 * @projectName: javaDemo
 * @package: com.akira.leetcode.triangle120
 * @className: Triangle
 * @author: tzk
 * @description: TODO
 * @date: 2025/2/26 13:30
 * @version: 1.0
 */
public class Triangle {
    public static void launch() {
        Triangle solution = new Triangle();
        int[][] triangle = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};
        int minimumTotal = solution.minimumTotal(ArrayUtil.trans2List(triangle));
        System.out.println(minimumTotal);
    }

    /**
     * <a href="https://leetcode.cn/problems/triangle/solutions/329143/san-jiao-xing-zui-xiao-lu-jing-he-by-leetcode-solu/?envType=study-plan-v2&envId=top-interview-150">三角形最小路径和</a>
     * @param triangle
     * @return int
     * @author Ak1ra
     * @date 2025/2/26 14:01
     * @description
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] f = new int[n];
        f[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            f[i] = f[i - 1] + triangle.get(i).get(i);
            // 逆向遍历 避免计算f[j]时 污染f[j - 1]
            for (int j = i - 1; j > 0; --j) {
                f[j] = Math.min(f[j - 1], f[j]) + triangle.get(i).get(j);
            }
            f[0] += triangle.get(i).get(0);
        }
        int minTotal = f[0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, f[i]);
        }
        return minTotal;
    }
}
