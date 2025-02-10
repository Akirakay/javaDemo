package com.akira.leetcode.launch;

import com.akira.leetcode.invertbinarytree226.InvertBinaryTree;

public class Solution {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        InvertBinaryTree.launch();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "ms");
    }
}
