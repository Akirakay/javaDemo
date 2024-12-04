package com.akira.leetcode.movezeros283;

import com.akira.leetcode.util.ArrayUtil;

/**
 * @projectName: javaDemo
 * @package: com.akira.leetcode.movezeros283
 * @className: MoveZero
 * @author: tzk
 * @description: TODO
 * @date: 2024/12/4 16:11
 * @version: 1.0
 */
public class MoveZeros {
    public static void launch() {
        MoveZeros solution = new MoveZeros();
        int[] nums = {0, 1, 0, 3, 12};
        solution.moveZeroes(nums);
        ArrayUtil.traverseOneDimensionalArray(nums);
    }

    /**
     * @param nums
     * @author tzk
     * @date 2024/12/4 16:11
     * @description
     */
    private void moveZeroes(int[] nums) {
        if (nums.length == 0) return;

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        // 剩下的都是0
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
