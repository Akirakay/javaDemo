package com.akira.leetcode.launch;

import com.akira.leetcode.houserobber198.HouseRobber;

public class Solution {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        HouseRobber.launch();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "ms");
    }
}
