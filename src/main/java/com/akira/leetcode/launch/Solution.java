package com.akira.leetcode.launch;

import com.akira.leetcode.maxincreasetokeepcityskyline807.MaxIncreaseToKeepCitySkyline;

public class Solution {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        MaxIncreaseToKeepCitySkyline.launch();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "ms");
    }
}
