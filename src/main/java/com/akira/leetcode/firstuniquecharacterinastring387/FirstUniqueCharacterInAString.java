package com.akira.leetcode.firstuniquecharacterinastring387;

import java.util.HashMap;
import java.util.Map;

/**
 * @projectName: javaDemo
 * @package: com.akira.leetcode.firstuniquecharacterinastring387
 * @className: FirstUniqueCharacterInAString
 * @author: tzk
 * @description: TODO
 * @date: 2025/3/7 22:14
 * @version: 1.0
 */
public class FirstUniqueCharacterInAString {
    public static void launch() {
        FirstUniqueCharacterInAString solution = new FirstUniqueCharacterInAString();
        int idx = solution.firstUniqChar("loveleetcode");
        System.out.println(idx);
    }

    /**
     * using hash
     * @param s
     * @return int
     * @author Ak1ra
     * @date 2025/3/7 22:14
     * @description
     */
    private int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
