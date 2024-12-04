package com.akira.leetcode.launch;

import com.akira.leetcode.movezeros283.MoveZeros;

public class Solution {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        MoveZeros.launch();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "ms");
    }
}
