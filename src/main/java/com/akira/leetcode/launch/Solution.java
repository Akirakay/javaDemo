package com.akira.leetcode.launch;

import com.akira.leetcode.symmetrictree101.SymmetricTree;

public class Solution {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        SymmetricTree.launch();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "ms");
    }
}
