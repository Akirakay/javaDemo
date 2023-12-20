package com.akira.leetcode.launch;

import com.akira.leetcode.findfirstandlastpositionofelementinsortedarray34.FindFirstAndLastPositionOfElementInSortedArray;

public class Solution {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        FindFirstAndLastPositionOfElementInSortedArray.launch();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "ms");
    }
}
