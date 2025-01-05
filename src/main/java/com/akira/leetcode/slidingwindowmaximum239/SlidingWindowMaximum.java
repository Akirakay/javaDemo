package com.akira.leetcode.slidingwindowmaximum239;

import com.akira.leetcode.util.ArrayUtil;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @projectName: javaDemo
 * @package: com.akira.leetcode.slidingwindowmaximum239
 * @className: SlidingWindowMaximum
 * @author: tzk
 * @description: TODO
 * @date: 2025/1/5 16:23
 * @version: 1.0
 */
public class SlidingWindowMaximum {
    public static void launch() {
        SlidingWindowMaximum solution = new SlidingWindowMaximum();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = solution.maxSlidingWindow(nums, k);
        ArrayUtil.traverseOneDimensionalArray(result);
    }

    /**
     * TODO: 稀疏表实现方案
     * 当前方案采用单调队列实现
     * <a href='https://leetcode.cn/problems/sliding-window-maximum/solutions/543426/hua-dong-chuang-kou-zui-da-zhi-by-leetco-ki6m/?envType=study-plan-v2&envId=top-100-liked' />
     * @param nums
     * @param k
     * @return int[]
     * @author Ak1ra
     * @date 2025/1/5 16:24
     * @description
     */
    private int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            // 移除不在当前窗口范围内的元素
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // 移除所有小于当前元素的索引
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // 添加当前元素索引
            deque.offerLast(i);

            // 记录当前窗口的最大值
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}
