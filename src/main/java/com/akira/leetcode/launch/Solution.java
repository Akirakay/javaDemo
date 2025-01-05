package com.akira.leetcode.launch;

import com.akira.leetcode.slidingwindowmaximum239.SlidingWindowMaximum;

public class Solution {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        SlidingWindowMaximum.launch();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "ms");
    }
}
