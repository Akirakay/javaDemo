package com.akira.leetcode.launch;

import com.akira.leetcode.jumpgame55.JumpGame;
import com.akira.leetcode.jumpgameii45.JumpGameII;

public class Solution {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        JumpGameII.launch();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "ms");
    }
}
