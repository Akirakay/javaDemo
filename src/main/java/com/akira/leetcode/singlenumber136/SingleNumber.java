package com.akira.leetcode.singlenumber136;

/**
 * @projectName: javaDemo
 * @package: com.akira.leetcode.singlenumber136
 * @className: SingleNumber
 * @author: tzk
 * @description: TODO
 * @date: 2024/12/2 10:07
 * @version: 1.0
 */
public class SingleNumber {
    public static void launch()
    {
        SingleNumber solution = new SingleNumber();
        int[] nums = {4,1,2,1,2};
        int singleNumber = solution.singleNumber(nums);
        System.out.println(singleNumber);
    }

    /**
     * <a href="https://leetcode.cn/problems/single-number/?envType=study-plan-v2&envId=top-100-likedhttps://leetcode.cn/problems/single-number/?envType=study-plan-v2&envId=top-100-liked />
     * 使用异或方式
     * @param nums
     * @return int
     * @author tzk
     * @date 2024/12/2 10:08
     * @description
     */
    private int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
