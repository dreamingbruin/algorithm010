package Week04;

import Common.Pair;
import Common.Tests;

public class BestTimeToBuyAndSellStock {

    public static class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length < 2) {
                return 0;
            }
            int sum = 0;
            for (int i = 1; i < prices.length; i++) {
                int profit = prices[i] - prices[i - 1];
                if (profit > 0) {
                    sum += profit;
                }
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        Tests.execute(Solution.class, new Pair<>(new Object[]{new int[]{7, 1, 5, 3, 6, 4}}, 7));
    }

}
