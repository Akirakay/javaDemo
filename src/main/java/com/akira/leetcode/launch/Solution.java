package com.akira.leetcode.launch;

import com.akira.leetcode.firstmissingpositive41.FirstMissingPositive;

public class Solution {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        FirstMissingPositive.launch();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "ms");
    }
}
