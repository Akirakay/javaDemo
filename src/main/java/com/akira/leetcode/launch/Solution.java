package com.akira.leetcode.launch;

import com.akira.leetcode.firstuniquecharacterinastring387.FirstUniqueCharacterInAString;

public class Solution {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        FirstUniqueCharacterInAString.launch();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "ms");
    }
}
