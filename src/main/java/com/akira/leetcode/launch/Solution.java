package com.akira.leetcode.launch;

import com.akira.leetcode.singlenumber136.SingleNumber;

public class Solution {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        SingleNumber.launch();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "ms");
    }
}
