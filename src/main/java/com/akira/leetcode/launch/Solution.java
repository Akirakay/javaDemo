package com.akira.leetcode.launch;

import com.akira.leetcode.binarytreelevelordertraversal102.BinaryTreeLevelOrderTraversal;

public class Solution {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        BinaryTreeLevelOrderTraversal.launch();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "ms");
    }
}
