package com.akira.leetcode.containerwithmostwater11;

/**
 * @projectName: javaDemo
 * @package: com.akira.leetcode.containerwithmostwater11
 * @className: ContainerWithMostWater
 * @author: tzk
 * @description: TODO
 * @date: 2024/12/19 11:07
 * @version: 1.0
 */
public class ContainerWithMostWater {
    public static void launch() {
        ContainerWithMostWater solution = new ContainerWithMostWater();
//        int[] height = {1,8,6,2,5,4,8,3,7};
        int[] height = {1,1};
        System.out.println(solution.maxArea(height));
    }

    private int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
