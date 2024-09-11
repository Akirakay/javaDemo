package com.akira.leetcode.launch;

import com.akira.leetcode.mergeintervals56.MergeIntervals;

public class Solution {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        MergeIntervals.launch();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "ms");
    }
}
