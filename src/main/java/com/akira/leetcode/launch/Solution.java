package com.akira.leetcode.launch;

import com.akira.leetcode.mergeksortedlists23.MergeKSortedLists;

public class Solution {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        MergeKSortedLists.launch();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "ms");
    }
}
