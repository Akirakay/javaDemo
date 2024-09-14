package com.akira.leetcode.removingstarsfromastring2390;

import java.util.Stack;

/**
 * @projectName: javaDemo
 * @package: com.akira.leetcode.removingstarsfromastring2390
 * @className: RemovingStarsFromAString
 * @author: tzk
 * @description: TODO
 * @date: 2024/9/14 16:55
 * @version: 1.0
 */
public class RemovingStarsFromAString {

    public static void launch() {
        RemovingStarsFromAString solution = new RemovingStarsFromAString();
        String s = solution.removeStars("leet**cod*e");
        System.out.println(s);
    }

    /**
     * 移除星号
     * <a href= "https://leetcode.cn/problems/removing-stars-from-a-string/solutions/2909118/cong-zi-fu-chuan-zhong-yi-chu-xing-hao-b-8fqm/" />
     * @param s
     * @return java.lang.String
     * @author tzk
     * @date 2024/9/14 17:02
     * @description
     */
    public String removeStars(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '*' && !stack.empty()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
