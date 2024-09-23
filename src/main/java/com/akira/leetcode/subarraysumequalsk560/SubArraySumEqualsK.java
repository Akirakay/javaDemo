package com.akira.leetcode.subarraysumequalsk560;

import java.util.HashMap;

/**
 * @projectName: javaDemo
 * @package: com.akira.leetcode.subarraysumequalsk560
 * @className: SubarraySumEqualsK
 * @author: tzk
 * @description: TODO
 * @date: 2024/9/23 22:01
 * @version: 1.0
 */
public class SubArraySumEqualsK {
    public static void launch() {
        SubArraySumEqualsK solution = new SubArraySumEqualsK();
        System.out.println(solution.subarraySum(new int[]{1, 1, 1}, 2));
    }

    /**
     * 前缀和 + 哈希表
     * <a href="https://leetcode.cn/problems/subarray-sum-equals-k/solutions/238572/he-wei-kde-zi-shu-zu-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked" />
     * 解题思路
     * 前缀和的概念:
     *
     * pre 变量表示从数组开始到当前位置的元素之和，即前缀和。
     * 例如，对于数组 [1, 2, 3]，前缀和 pre 在遍历到第二个元素时为 1 + 2 = 3。
     * 哈希表的作用:
     *
     * HashMap<Integer, Integer> mp 用于存储前缀和及其出现的次数。
     * 初始时，mp 中放入 (0, 1)，表示前缀和为 0 的情况出现了一次。这是为了处理从数组开头到某个位置的子数组和正好等于 k 的情况。
     * 遍历数组:
     *
     * 对于数组中的每个元素 num，更新前缀和 pre：pre += num。
     * 检查哈希表中是否存在 pre - k：
     * 如果存在，说明从某个位置到当前位置的子数组和为 k。
     * mp.get(pre - k) 返回的是 pre - k 出现的次数，即有多少个子数组的和为 k。
     * 将当前前缀和 pre 及其出现次数更新到哈希表中。
     * 返回结果:
     *
     * count 变量记录了所有满足条件的子数组的数量。
     * 最后返回 count。
     * @param nums
     * @param k
     * @return int
     * @author akira
     * @date 2024/9/23 22:14
     * @description
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap < Integer, Integer > mp = new HashMap< >();
        mp.put(0, 1);
        for (int num : nums) {
            pre += num;
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
