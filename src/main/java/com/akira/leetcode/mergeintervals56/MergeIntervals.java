package com.akira.leetcode.mergeintervals56;

import com.akira.leetcode.util.ArrayUtil;

import java.util.*;

/**
 * @projectName: javaDemo
 * @package: com.akira.leetcode.mergeintervals56
 * @className: MergeIntervals
 * @author: tzk
 * @description: TODO
 * @date: 2024/9/11 16:12
 * @version: 1.0
 */
public class MergeIntervals {
    public static void launch() {
        MergeIntervals solution = new MergeIntervals();
        int[][] merge = solution.mergeOfficial(new int[][]{{1, 3}, {8, 10}, {2, 6}, {15, 18}});
        ArrayUtil.traverseTwoDimensionalArray(merge);
    }

    public int[][] mergeOfficial(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        int n = intervals.length;
        int i = 0;
        List<int[]> ranges = new ArrayList<>(n);
        while(i < n){
            int start = intervals[i][0];
            int end = intervals[i][1];
            int j = i + 1;
            while(j < n && intervals[j][0] <= end){
                end = Math.max(end, intervals[j++][1]);
            }
            ranges.add(new int[]{start, end});
            i = j;
        }
        return ranges.toArray(new int[ranges.size()][]);
    }
    public int[][] merge(int[][] intervals) {
        // sort array
        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[i][0] > intervals[j][0]) {
                    int[] temp = intervals[i];
                    intervals[i] = intervals[j];
                    intervals[j] = temp;
                }
            }
        }

        // merge array
        Stack<int[]> stack = new Stack<>();
        for (int[] interval : intervals) {
            if (stack.isEmpty()) {
                stack.push(interval);
            } else {
                int[] top = stack.peek();
                if (top[1] >= interval[0]) {
                    top[1] = Math.max(top[1], interval[1]);
                } else {
                    stack.push(interval);
                }
            }
        }
        return stack.toArray(new int[stack.size()][]);
    }

}
