package com.akira.leetcode.launch;

import com.akira.leetcode.removingstarsfromastring2390.RemovingStarsFromAString;

public class Solution {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        RemovingStarsFromAString.launch();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "ms");
    }
}
