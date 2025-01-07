package com.lyz.top.greedy;

/**
 * @Auther: Jensen
 * @Date: 2025-01-05 - 01 - 05 - 0:06
 * @Description: com.lyz.top
 * @version: 1.0
 */
public class Question122 {
    static class Solution {
        public static int maxProfit(int[] prices) {
            int res = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] - prices[i-1] > 0) {
                    res += prices[i] - prices[i-1];
                }
            }
            return res;
        }

    }

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        int res = Solution.maxProfit(prices);
        System.out.println(res);
    }
}

