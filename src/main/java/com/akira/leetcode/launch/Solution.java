package com.akira.leetcode.launch;

import com.akira.leetcode.takekofeachcharacterfromleftandright2516.TakeKOfEachCharacterFromLeftAndRight;

public class Solution {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        TakeKOfEachCharacterFromLeftAndRight.launch();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "ms");
    }
}
