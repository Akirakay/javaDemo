package com.akira.leetcode.launch;

import com.akira.leetcode.maximumdepthofbinarytree104.MaximumDepthOfBinaryTree;

public class Solution {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        MaximumDepthOfBinaryTree.launch();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "ms");
    }
}
