package com.akira.leetcode.jumpgame55;

public class JumpGame {
    public static void launch() {
        JumpGame solution = new JumpGame();
        boolean flag = solution.canJump(new int[] { 2, 3, 1, 1, 4 });
        System.out.println(flag);
    }

    public boolean canJump(int[] nums) {
        int len = nums.length;
        int maxRange = 0;
        for (int i = 0; i <= maxRange; i++) { // i <= maxRange 是关键 在覆盖范围内不断更新自己的最大覆盖范围
            if (maxRange <= i + nums[i]) {
                maxRange = i + nums[i];
            }
            if (maxRange >= len - 1) {
                return true;
            }
        }
        return false;
    }
}
