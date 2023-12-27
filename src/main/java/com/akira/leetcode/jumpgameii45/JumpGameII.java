package com.akira.leetcode.jumpgameii45;


public class JumpGameII {
    public static void launch() {
        JumpGameII solution = new JumpGameII();
        int[] arr = new int[]{2, 3, 1, 1, 4};
        int jump = solution.jumpForward(arr);
        System.out.println(jump);
    }

    // 反向查找
    public int jumpBackward(int[] nums) {
        int position = nums.length - 1;
        int steps = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (i + nums[i] >= position) {
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }

    // 正向查找
    public int jumpForward(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

}
