package com.akira.leetcode.launch;

import com.akira.leetcode.trappingrainwater42.TrappingRainWater;

public class Solution {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        TrappingRainWater.launch();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "ms");
    }
}
