package com.akira.leetcode.hindex274;

import java.util.Arrays;

public class HIndex {
    public static void launch() {
        HIndex solution = new HIndex();
        int[] arr = new int[]{3, 0, 6, 1, 5};
        System.out.println(solution.hIndexUsingSort(arr));
    }

    /**
     * using sort
     * https://leetcode.cn/problems/h-index/solutions/869042/h-zhi-shu-by-leetcode-solution-fnhl/
     */
    public int hIndexUsingSort(int[] citations) {
        Arrays.sort(citations);
        int h = 0, i = citations.length - 1;
        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }
        return h;
    }

    /**
     * using counter
     * https://leetcode.cn/problems/h-index/solutions/869042/h-zhi-shu-by-leetcode-solution-fnhl/
     * 思路接近暴力解法 规避了暴力解的冗余步骤
     * @param citations
     * @return
     */
    public int hIndexUsingCounter(int[] citations) {
        int n = citations.length, tot = 0;
        int[] counter = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n) {
                counter[n]++;
            } else {
                counter[citations[i]]++;
            }
        }
        for (int i = n; i >= 0; i--) {
            tot += counter[i];
            if (tot >= i) {
                return i;
            }
        }
        return 0;
    }

    // 暴力解法
    public int hIndex(int[] citations) {
        int max = Integer.MIN_VALUE;
        int len = citations.length;
        for (int i = 0; i < len; i++) {
            max = Math.max(citations[i], max);
        }
        while (max >= 0) {
            if (max <= len) {
                int times = 0;
                for (int j = 0; j < len; j++) {
                    if (citations[j] >= max) {
                        times++;
                    }
                }
                if (times >= max) {
                    return max;
                }
            }
            max--;
        }
        return 0;
    }
}
