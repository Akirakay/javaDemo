package com.akira.leetcode.longestsubstringwithoutrepeatingcharacters3;


import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void launch() {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        int len = solution.lengthOfLongestSubstring("pwwkew");
        System.out.println(len);
    }

    public int lengthOfLongestSubstring(String s) {
        StringBuilder sb = new StringBuilder();
        int maxLen = 0;
        if (s != null) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int index = sb.indexOf(String.valueOf(c));
                if (index == -1) {
                    sb.append(c);
                } else {
                    String tempStr = sb.substring(index + 1);
                    sb = new StringBuilder();
                    sb.append(tempStr);
                    sb.append(c);
                }
                maxLen = Math.max(maxLen, sb.length());
            }
        }
        return maxLen;
    }

    // 维持一个滑动窗口
    public int lengthOfLongestSubstringOfficial(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                // 调整窗口最左索引
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            // 更新最大长度
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
