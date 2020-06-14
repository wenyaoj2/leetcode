class MaxProfitWithFee {
    public int maxProfit(int[] prices, int fee) {
        if(prices.length == 0) {
            return 0;
        }
        int[] buy = new int[prices.length];
        buy[0] = prices[0];
        int[] sell = new int[prices.length];
        for(int i = 1; i < prices.length; i++) {
            buy[i] = Math.min(buy[i - 1], prices[i] - sell[i - 1]);
            sell[i] = Math.max(sell[i - 1], prices[i] - buy[i - 1] - fee);
        }
        return sell[prices.length - 1];
    }
}