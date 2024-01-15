package com.akira.leetcode.launch;

import com.akira.leetcode.removeduplicatesfromsortedlistii82.RemoveDuplicatesFromSortedListII;

public class Solution {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        RemoveDuplicatesFromSortedListII.launch();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "ms");
    }
}
