package com.akira.leetcode.launch;

import com.akira.leetcode.sortcolors75.SortColors;

public class Solution {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        SortColors.launch();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "ms");
    }
}
