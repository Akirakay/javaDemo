package com.akira.leetcode.twosumiiinputarrayissorted167;

public class TwoSumIIInputArrayIsSorted {
    public static void launch() {
        TwoSumIIInputArrayIsSorted solution = new TwoSumIIInputArrayIsSorted();
        int[] res = solution.twoSum(new int[]{2, 3, 4, 5, 7, 9}, 7);
        for (int i : res) {
            System.out.println(i);
        }
    }

    public int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[]{low + 1, high + 1};
            } else if (sum < target) {
                low++;
            } else {
                high--;
            }
        }
        return new int[]{-1, -1};
    }
}
