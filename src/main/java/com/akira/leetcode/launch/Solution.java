package com.akira.leetcode.launch;

import com.akira.leetcode.minimumpathsum64.MinimumPathSum;

public class Solution {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        MinimumPathSum.launch();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "ms");
    }
}
