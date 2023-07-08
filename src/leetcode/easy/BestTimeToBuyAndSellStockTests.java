package leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


// @see https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BestTimeToBuyAndSellStockTests {

    @Test
    public void case1() {
        assertEquals(5, maxProfit(new int[] {7,1,5,3,6,4}));
    }

    @Test
    public void case2() {
        assertEquals(0, maxProfit(new int[] {7,6,4,3,1}));
    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        int priceMin = prices[0];

        for (int day = 1; day < prices.length; day++) {
            if (prices[day] < priceMin) priceMin = prices[day];
            profit = Math.max(profit, prices[day] - priceMin);
        }

        return profit;
    }
}
