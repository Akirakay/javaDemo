package com.akira.leetcode.launch;

import com.akira.leetcode.uniquepaths62.UniquePaths;

public class Solution {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        UniquePaths.launch();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "ms");
    }
}
