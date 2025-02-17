package com.akira.leetcode.launch;

import com.akira.leetcode.partitionlabels763.PartitionLabels;

public class Solution {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        PartitionLabels.launch();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "ms");
    }
}
