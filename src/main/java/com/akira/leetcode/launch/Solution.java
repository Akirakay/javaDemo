package com.akira.leetcode.launch;

import com.akira.leetcode.minimumsizesubarraysum209.MinimumSizeSubarraySum;

public class Solution {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        MinimumSizeSubarraySum.launch();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "ms");
    }
}
