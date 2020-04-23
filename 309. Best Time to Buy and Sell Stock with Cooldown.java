
class BestTimetoBuyandSellStockwithCooldown {
    public int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int[] buy = new int[prices.length + 1];
        int[] sell = new int[prices.length + 1];
        buy[0] = Integer.MIN_VALUE;
        buy[1] = -prices[0];
        for(int i = 2; i <= prices.length; i++){
            buy[i] = Math.max(buy[i-1], sell[i-2] - prices[i-1]);
            sell[i] = Math.max(sell[i-1], buy[i-1]+prices[i-1]);
        }
        return sell[prices.length];
    }
}