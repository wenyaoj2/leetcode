class MaxProfit {
    public int maxProfit(int[] prices) {
        int res = 0;
        int curMax = 0;
        for(int i = 1; i < prices.length; i++) {
            curMax = Math.max(curMax + prices[i] - prices[i - 1], 0);
            res = Math.max(res, curMax);
        }
        return res;
    }
}