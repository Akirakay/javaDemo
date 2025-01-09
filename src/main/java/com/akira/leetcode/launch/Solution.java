package com.akira.leetcode.launch;

import com.akira.leetcode.minimumwindowsubstring76.MinimumWindowSubstring;

public class Solution {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        MinimumWindowSubstring.launch();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "ms");
    }
}
