package com.akira.leetcode.launch;

import com.akira.leetcode.reversewordsinastring151.ReverseWordsInAString;

public class Solution {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        ReverseWordsInAString.launch();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "ms");
    }
}
