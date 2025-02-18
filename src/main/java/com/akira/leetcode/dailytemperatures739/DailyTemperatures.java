package com.akira.leetcode.dailytemperatures739;

import com.akira.leetcode.util.ArrayUtil;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @projectName: javaDemo
 * @package: com.akira.leetcode.dailytemperatures739
 * @className: DailyTemperatures
 * @author: tzk
 * @description: TODO
 * @date: 2025/2/18 10:18
 * @version: 1.0
 */
public class DailyTemperatures {
    public static void launch() {
        DailyTemperatures solution = new DailyTemperatures();
        int[] arr = solution.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        ArrayUtil.traverseOneDimensionalArray(arr);
    }

    /**
     *
     * @param temperatures
     * @return int[]
     * @author Ak1ra
     * @date 2025/2/18 10:19
     * @description
     */
    private int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }
}
