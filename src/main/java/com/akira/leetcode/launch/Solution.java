package com.akira.leetcode.launch;

import com.akira.leetcode.wordbreak139.WordBreak;

public class Solution {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        WordBreak.launch();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "ms");
    }
}
