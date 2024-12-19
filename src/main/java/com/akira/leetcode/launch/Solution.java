package com.akira.leetcode.launch;

import com.akira.leetcode.containerwithmostwater11.ContainerWithMostWater;

public class Solution {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        ContainerWithMostWater.launch();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "ms");
    }
}
