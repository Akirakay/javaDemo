package com.akira.leetcode.findtheduplicatenumber287;

/**
 * @projectName: javaDemo
 * @package: com.akira.leetcode.findtheduplicatenumber287
 * @className: FindTheDuplicateNumberr
 * @author: tzk
 * @description: TODO
 * @date: 2024/9/14 13:38
 * @version: 1.0
 */
public class FindTheDuplicateNumber {
    public static void launch() {
        FindTheDuplicateNumber solution = new FindTheDuplicateNumber();
        int idx = solution.findDuplicate(new int[]{1, 3, 4, 2, 2});
        System.out.println(idx);
    }

    /**
     * Floyd 判圈算法
     * 此题能使用判圈算法的重要一点在于nums[i]值的范围
     * one of official solution
     * <a href="https://leetcode.cn/problems/find-the-duplicate-number/solutions/261119/xun-zhao-zhong-fu-shu-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked" />
     * @param nums
     * @return int
     * @author tzk
     * @date 2024/9/14 14:26
     * @description
     */
    public int findDuplicate(int[] nums) {
        // 初始化龟和兔指针
        int tortoise = nums[0];
        int hare = nums[0];

        // 阶段1：找到循环中的交点
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // 阶段2：找到循环的入口
        tortoise = nums[0];
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }

        // 循环的入口即为重复的数字
        return hare;
    }

}
