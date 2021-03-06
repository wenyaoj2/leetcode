class MaxProfitIV {
    public int maxProfit(int k, int[] prices) {
        if(prices.length == 0) {
            return 0;
        }
        int res = 0;
        if(k > prices.length / 2) {
            for(int i = 1; i < prices.length; i++) {
                if(prices[i] > prices[i - 1]) {
                    res += prices[i] - prices[i - 1];
                }
            }
            return res;
        }
        int[][] dp = new int[k + 1][prices.length];
        for(int i = 1; i <= k; i++) {
            int min = prices[0];
            for(int j = 1; j < prices.length; j++) {
                min = Math.min(min, prices[j] - dp[i - 1][j - 1]);
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] - min);
            }
        }
        return dp[k][prices.length - 1];
    }
}