package com.akira.leetcode.sortcolors75;

import com.akira.leetcode.util.ArrayUtil;

/**
 * @projectName: javaDemo
 * @package: com.akira.leetcode.sortcolors75
 * @className: SortColors
 * @author: tzk
 * @description: TODO
 * @date: 2024/11/28 10:28
 * @version: 1.0
 */
public class SortColors {
    public static void launch() {
        SortColors solution = new SortColors();
        int[] nums = {2, 0, 2, 1, 1, 0};
        solution.sortColors2(nums);
        ArrayUtil.traverseOneDimensionalArray(nums);
    }

    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int left = 0;
        int right = nums.length - 1;
        for (int i = left; i < right; i++) {
            for (int j = right; j > i; j--) {
                if (nums[j] < nums[i]) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
    }

    /**
     * <a href="https://leetcode.cn/problems/sort-colors/solutions/437968/yan-se-fen-lei-by-leetcode-solution">official solution</a>
     * 这段Java代码实现了对数组 nums 中的元素进行排序，使得所有0都排在前面，所有1在中间，所有2在最后。具体步骤如下：
     * 初始化两个指针 p0 和 p2，分别指向数组的起始位置和末尾位置。
     * 遍历数组，对于每个元素：
     * 如果当前元素是2，将其与 p2 指向的元素交换，并将 p2 左移一位。
     * 如果当前元素是0，将其与 p0 指向的元素交换，并将 p0 右移一位。
     * 重复上述步骤直到遍历完整个数组。
     * @param nums
     * @return void
     * @author tzk
     * @date 2024/11/28 10:54
     * @description
     */
    public void sortColors2(int[] nums) {
        int n = nums.length;
        int p0 = 0, p2 = n - 1;
        for (int i = 0; i <= p2; ++i) {
            // while 循环确保交换后的 nums[i] != 2
            while (i <= p2 && nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = temp;
                --p2;
            }
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                ++p0;
            }
        }
    }
}
