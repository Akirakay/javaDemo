package com.akira.leetcode.minimumwindowsubstring76;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @projectName: javaDemo
 * @package: com.akira.leetcode.minimumwindowsubstring76
 * @className: MinimumWindowSubstring
 * @author: tzk
 * @description: TODO
 * @date: 2025/1/9 11:28
 * @version: 1.0
 */
public class MinimumWindowSubstring {
    public static void launch() {
        MinimumWindowSubstring solution = new MinimumWindowSubstring();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String res = solution.minWindow2(s, t);
        System.out.println(res);
    }

    /**
     * 滑动窗口算法
     * <a href="https://leetcode.cn/problems/minimum-window-substring/solutions/257359/zui-xiao-fu-gai-zi-chuan-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked" />
     * @param s
     * @param t
     * @return java.lang.String
     * @author Ak1ra
     * @date 2025/1/9 11:29
     * @description
     */
    private String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // 记录目标字符的频率
        Map<Character, Integer> targetFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetFreq.put(c, targetFreq.getOrDefault(c, 0) + 1);
        }

        // 滑动窗口中的字符频率
        Map<Character, Integer> windowFreq = new HashMap<>();
        int left = 0, right = 0; // 窗口左右指针
        int validCount = 0; // 当前满足条件的字符个数
        int minLen = Integer.MAX_VALUE; // 最小长度
        int start = 0; // 最小覆盖子串的起始位置

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            // 如果当前字符是目标字符的一部分，更新窗口中的频率
            if (targetFreq.containsKey(c)) {
                windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);
                if (windowFreq.get(c).equals(targetFreq.get(c))) {
                    validCount++;
                }
            }

            // 判断是否可以收缩窗口
            while (validCount == targetFreq.size()) {
                // 更新最小子串
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                char d = s.charAt(left);
                left++;

                // 更新窗口中的频率
                if (targetFreq.containsKey(d)) {
                    if (windowFreq.get(d).equals(targetFreq.get(d))) {
                        validCount--;
                    }
                    windowFreq.put(d, windowFreq.get(d) - 1);
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    /**
     * 优化后的滑动窗口算法:预处理s字符串
     * @param s
     * @param t
     * @return
     */
    private String minWindow2(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // 记录目标字符的频率
        Map<Character, Integer> targetFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetFreq.put(c, targetFreq.getOrDefault(c, 0) + 1);
        }

        // 预处理 s，只保留 t 中的字符及其索引
        List<int[]> filteredS = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (targetFreq.containsKey(c)) {
                filteredS.add(new int[]{i, c});
            }
        }

        // 滑动窗口中的字符频率
        Map<Character, Integer> windowFreq = new HashMap<>();
        int left = 0, right = 0; // 窗口左右指针
        int validCount = 0; // 当前满足条件的字符个数
        int minLen = Integer.MAX_VALUE; // 最小长度
        int start = 0; // 最小覆盖子串的起始位置

        // 滑动窗口操作
        while (right < filteredS.size()) {
            char c = (char) filteredS.get(right)[1];
            right++;

            // 更新窗口中的频率
            windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);
            if (windowFreq.get(c).equals(targetFreq.get(c))) {
                validCount++;
            }

            // 判断是否可以收缩窗口
            while (validCount == targetFreq.size()) {
                int startIdx = filteredS.get(left)[0];
                int endIdx = filteredS.get(right - 1)[0];

                // 更新最小子串
                if (endIdx - startIdx + 1 < minLen) {
                    minLen = endIdx - startIdx + 1;
                    start = startIdx;
                }

                char d = (char) filteredS.get(left)[1];
                left++;

                // 更新窗口中的频率
                windowFreq.put(d, windowFreq.get(d) - 1);
                if (windowFreq.get(d) < targetFreq.get(d)) {
                    validCount--;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
