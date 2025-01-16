package com.akira.leetcode.launch;

import com.akira.leetcode.spiralmatrix54.SpiralMatrix;

public class Solution {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        SpiralMatrix.launch();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "ms");
    }
}
