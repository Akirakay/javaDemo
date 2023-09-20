package com.akira.leetcode.maxsumsubarray53;

public class MaxSumSubArray {
    public static void launch() {
        MaxSumSubArray solution = new MaxSumSubArray();
        // int maxSum = maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 });
        // int maxSum = solution.maxSubArray(new int[] { 5, 4, -1, 7, 8 });
        int maxSum = solution.maxSubArrayDivideAndConquer(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 });
        System.out.println(maxSum);
    }

    // 1.动态规划
    private int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int prevSum = 0;
        for (int i : nums) {
            prevSum = Math.max(i, prevSum + i);
            maxSum = Math.max(prevSum, maxSum);
        }
        return maxSum;
    }

    // 分治
    /**
     * 
     */
    private int maxSubArrayDivideAndConquer(int[] nums) {
        return getInfo(nums, 0, nums.length - 1).mSum;
    }

    public Status getInfo(int[] a, int l, int r) {
        if (l == r) {
            return new Status(a[l], a[l], a[l], a[l]);
        }
        int m = (l + r) >> 1;
        Status lSub = getInfo(a, l, m);
        Status rSub = getInfo(a, m + 1, r);
        return pushUp(lSub, rSub);
    }

    public Status pushUp(Status l, Status r) {
        int iSum = l.iSum + r.iSum;
        int lSum = Math.max(l.lSum, l.iSum + r.lSum);
        int rSum = Math.max(r.rSum, r.iSum + l.rSum);
        int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
        return new Status(lSum, rSum, mSum, iSum);
    }

    public class Status {
        public int lSum, rSum, mSum, iSum;

        public Status(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }
    }

}
