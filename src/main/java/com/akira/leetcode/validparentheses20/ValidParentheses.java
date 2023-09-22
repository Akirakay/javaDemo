package com.akira.leetcode.validparentheses20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void launch() {
        ValidParentheses solution = new ValidParentheses();
        boolean valid = solution.isValid("([}}])");
        System.out.println(valid);
    }

    /**
     * 如果不需要保证顺序 则不用使用栈 直接统计对应数量是否一致
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> pairMap = new HashMap<>();
        pairMap.put(']', '[');
        pairMap.put('}', '{');
        pairMap.put(')', '(');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (pairMap.containsKey(c)) {
                if (stack.empty() || !stack.pop().equals(pairMap.get(c))) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.empty();
    }
}
