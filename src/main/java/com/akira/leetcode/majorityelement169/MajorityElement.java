package com.akira.leetcode.majorityelement169;

/**
 * @projectName: javaDemo
 * @package: com.akira.leetcode.majorityelement169
 * @className: MajorityElement
 * @author: tzk
 * @description: TODO
 * @date: 2024/12/1 13:30
 * @version: 1.0
 */
public class MajorityElement {
    public static void launch() {
        MajorityElement solution = new MajorityElement();
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int majorityElement = solution.majorityElement(nums);
        System.out.println(majorityElement);
    }

    /**
     *
     * @param nums
     * @return int
     * @author tzk
     * @date 2024/12/1 13:33
     * @description
     */
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int times = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) {
                times++;
            } else {
                if (times == 0) {
                    candidate = nums[i];
                    times++;
                } else {
                    times--;
                }

            }
        }
        return candidate;
    }
}
