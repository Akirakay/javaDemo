package com.akira.leetcode.launch;

import com.akira.leetcode.hindex274.HIndex;

public class Solution {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        HIndex.launch();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "ms");
    }
}
