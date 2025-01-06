package com.akira.leetcode.longestvalidparentheses32;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @projectName: javaDemo
 * @package: com.akira.leetcode.longestvalidparentheses32
 * @className: LongestValidParentheses
 * @author: tzk
 * @description: TODO
 * @date: 2025/1/6 13:40
 * @version: 1.0
 */
public class LongestValidParentheses {
    public static void launch() {
        LongestValidParentheses solution = new LongestValidParentheses();
//        String s = "(()";
//        String s = "";
        String s = ")()())";
        int length = solution.longestValidParentheses(s);
        System.out.println(length);
    }

    /**
     * ans1: using DP
     * ans2: using stack
     * ans3: using greedy algorithm
     * <a href='https://leetcode.cn/problems/longest-valid-parentheses/solutions/314683/zui-chang-you-xiao-gua-hao-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked' />
     * @param s
     * @return int
     * @author Ak1ra
     * @date 2025/1/6 13:41
     * @description
     */
    private int longestValidParentheses(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
}
