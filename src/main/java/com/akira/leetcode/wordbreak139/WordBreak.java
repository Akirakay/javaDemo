package com.akira.leetcode.wordbreak139;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @projectName: javaDemo
 * @package: com.akira.leetcode.wordbreak139
 * @className: WordBreak
 * @author: tzk
 * @description: TODO
 * @date: 2024/12/16 14:35
 * @version: 1.0
 */
public class WordBreak {
    public static void launch() {
        WordBreak solution = new WordBreak();
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        boolean b = solution.wordBreak(s, wordDict);
        System.out.println(b);
    }

    /**
     * dp[i] = dp[j] + check(s[j:i])
     * @param s
     * @param wordDict
     * @return boolean
     * @author tzk
     * @date 2024/12/16 14:36
     * @description
     */
    private boolean wordBreak(String s, List<String> wordDict) {
        if (s == null) {
            return false;
        }
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordSet) {
                int len = word.length();
                if (i >= len && dp[i - len] && wordSet.contains(s.substring(i - len, i))) {
                    dp[i] = true;
                    break; // 当前 i 已经可以拼接，跳出循环
                }
            }
        }
        return dp[s.length()];
    }

    /**
     * dp[i] = dp[j] + check(s[j:i])
     * j: 分界index
     * 也可结合 {@code tire 字典树} 实现
     * @param s
     * @param wordDict
     * @return boolean
     * @author tzk
     * @date 2024/12/16 14:36
     * @description
     */
    private boolean wordBreakOfficial(String s, List<String> wordDict) {
        if (s == null) {
            return false;
        }
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
