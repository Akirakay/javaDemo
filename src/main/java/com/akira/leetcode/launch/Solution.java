package com.akira.leetcode.launch;

import com.akira.leetcode.constructstringwithrepeatlimit2182.ConstructStringWithRepeatLimit;

public class Solution {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        ConstructStringWithRepeatLimit.launch();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "ms");
    }
}
