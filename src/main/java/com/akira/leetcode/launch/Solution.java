package com.akira.leetcode.launch;

import com.akira.leetcode.findallanagramsinastring438.FindAllAnagramsInAString;

public class Solution {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        FindAllAnagramsInAString.launch();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "ms");
    }
}
