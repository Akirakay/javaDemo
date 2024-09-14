package com.akira.leetcode.launch;

import com.akira.leetcode.findtheduplicatenumber287.FindTheDuplicateNumber;

public class Solution {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        FindTheDuplicateNumber.launch();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "ms");
    }
}
