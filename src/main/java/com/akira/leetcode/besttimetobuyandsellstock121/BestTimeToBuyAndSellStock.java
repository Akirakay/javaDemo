package com.akira.leetcode.besttimetobuyandsellstock121;

public class BestTimeToBuyAndSellStock {
    public static void launch() {
        BestTimeToBuyAndSellStock solution = new BestTimeToBuyAndSellStock();
        int profit = solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(profit);
    }

    /**
     * 暴力解法：超时
     * @param prices
     * @return int
     * @author Ak1ra
     * @date 2025/1/8 11:28
     * @description
     */
    public int maxProfitN2(int[] prices) {
        int maxProfit = 0;
        if (prices.length > 0) {
            for (int i = 0; i < prices.length - 1; i++) {
                for (int j = i + 1; j < prices.length; j++) {
                    if (prices[i] <= prices[j]) {
                        maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
                    }
                }
            }
        }
        return maxProfit;
    }

    /**
     * 如果当前i下标对应的就是最小值，那么说明第i天卖出无法获取利润，直接不卖，利润是0
     * 如果当前i下标对应的不是最小值，那么说明可以在前i-1天以最低成本去买入股票，然后第i天卖出，利润=第i天价格-最低成本[通过遍历是已知的]
     * 然后遍历，从局部利润，算出全局最大利润
     */
    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                // 求出到此时的最优购买价格
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                // 此刻卖出的利润属于最大利润
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }
}
