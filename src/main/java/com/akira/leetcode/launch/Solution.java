package com.akira.leetcode.launch;

import substringwithconcatenationofallwords30.SubstringWithConcatenationOfAllWords;

public class Solution {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        SubstringWithConcatenationOfAllWords.launch();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "ms");
    }
}
