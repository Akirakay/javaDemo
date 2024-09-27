package com.akira.leetcode.takekofeachcharacterfromleftandright2516;

/**
 * @projectName: javaDemo
 * @package: com.akira.leetcode.takekofeachcharacterfromleftandright2516
 * @className: TakeKOfEachCharacterFromLeftAndRight
 * @author: tzk
 * @description: TODO
 * @date: 2024/9/27 23:49
 * @version: 1.0
 */
public class TakeKOfEachCharacterFromLeftAndRight {
    public static void launch() {
        TakeKOfEachCharacterFromLeftAndRight solution = new TakeKOfEachCharacterFromLeftAndRight();
        int n = solution.takeCharacters("aabaaaacaabc", 2);
        System.out.println(n);
    }

    /**
     * <a href="https://leetcode.cn/problems/take-k-of-each-character-from-left-and-right/solutions/2928177/mei-chong-zi-fu-zhi-shao-qu-k-ge-by-leet-10ct" />
     * @param s
     * @param k
     * @return int
     * @author tzk
     * @date 2024/9/28 00:12
     * @description
     */
    public int takeCharacters(String s, int k) {
        int[] cnt = new int[3];
        int len = s.length();
        int ans = len;
        for (int i = 0; i < len; i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        if (isSucceed(k, cnt)) {
            ans = Math.min(ans, len);
        } else {
            return -1;
        }

        int l = 0;
        for (int r = 0; r < len; r++) {
            cnt[s.charAt(r) - 'a']--;
            while (l < r && (cnt[0] < k || cnt[1] < k || cnt[2] < k)) {
                cnt[s.charAt(l) - 'a']++;
                l++;
            }
            if (isSucceed(k, cnt)) {
                ans = Math.min(ans, len - (r - l + 1));
            }
        }

        return ans;

    }

    private static boolean isSucceed(int k, int[] cnt) {
        return cnt[0] >= k && cnt[1] >= k && cnt[2] >= k;
    }
}
