class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit = 0;
        int low = prices[0];
        for (int i=1;i<n;i++){
           int temp = prices[i] - low;
           profit = Math.max(profit,temp);
           low = Math.min(low,prices[i]);
        }
        return profit;
    }
}