package com.akira.leetcode.launch;

import com.akira.leetcode.partitionequalsubsetsum416.PartitionEqualSubsetSum;

public class Solution {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        PartitionEqualSubsetSum.launch();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "ms");
    }
}
