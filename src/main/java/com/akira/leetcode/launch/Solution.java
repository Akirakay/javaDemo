package com.akira.leetcode.launch;

import com.akira.leetcode.dailytemperatures739.DailyTemperatures;

public class Solution {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        DailyTemperatures.launch();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "ms");
    }
}
