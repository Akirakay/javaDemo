package com.akira.leetcode.launch;

import com.akira.leetcode.longestconsecutivesequence128.LongestConsecutiveSequence;

public class Solution {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        LongestConsecutiveSequence.launch();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "ms");
    }
}
