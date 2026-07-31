class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit = 0;
        int buyPrice = prices[0];
        for(int i = 0; i < n; i++){
            if(prices[i] < buyPrice){
                buyPrice = prices[i];
            }

            profit = Math.max(profit, prices[i] - buyPrice);
        }
        return profit;
    }
}
