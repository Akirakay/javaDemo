package com.akira.leetcode.launch;

import com.akira.leetcode.coinchange322.CoinChange;

public class Solution {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        CoinChange.launch();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "ms");
    }
}
