package com.akira.leetcode.launch;

import com.akira.leetcode.searcha2dmatrixii240.SearchA2DMatrixII;

public class Solution {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        SearchA2DMatrixII.launch();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "ms");
    }
}
