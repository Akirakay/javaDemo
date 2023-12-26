package com.akira.leetcode.launch;

import com.akira.leetcode.removeduplicatesfromsortedarrayii80.RemoveDuplicatesFromSortedArrayII;

public class Solution {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        RemoveDuplicatesFromSortedArrayII.launch();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "ms");
    }
}
