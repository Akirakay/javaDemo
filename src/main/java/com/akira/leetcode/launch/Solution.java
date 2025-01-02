package com.akira.leetcode.launch;

import com.akira.leetcode.maximumproductsubarray152.MaximumProductSubarray;

public class Solution {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        MaximumProductSubarray.launch();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "ms");
    }
}
