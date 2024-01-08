package com.akira.leetcode.reversewordsinastring151;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWordsInAString {
    public static void launch() {
        ReverseWordsInAString solution = new ReverseWordsInAString();
        System.out.println(solution.reverseWordsUsingLanguageSyntax("hello world"));
    }

    // 从后往前添加字符串
    public String reverseWords(String s) {
        // 使用双指针
        int m = s.length() - 1;
        StringBuilder res = new StringBuilder();
        // 除去尾部空格
        while (s.charAt(m) == ' ' && m > 0) m--;
        int n = m; // n是另一个指针
        while (m >= 0) {
            while (m >= 0 && s.charAt(m) != ' ') m--;
            res.append(s.substring(m + 1, n + 1) + " "); // 获取单词并加上空格
            while (m >= 0 && s.charAt(m) == ' ') m--;
            n = m;
        }
        return res.substring(0, res.length() - 1); // 忽略最后一位的空格
    }

    // 利用语言特性
    public String reverseWordsUsingLanguageSyntax(String s) {
        s = s.trim();
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }
}
