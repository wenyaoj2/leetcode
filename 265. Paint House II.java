class PaintHouseII {
    public int minCostII(int[][] costs) {
        if(costs.length == 0){
            return 0;
        }
        int[][] dp = new int[costs.length][costs[0].length];
        for(int i = 0; i < costs.length; i++){
            for(int j = 0; j < costs[i].length; j++){
                if(i == 0){
                    dp[i][j] = costs[i][j];
                    continue;
                }
                int min = Integer.MAX_VALUE;
                for(int k = 0; k < costs[0].length; k++){
                    if(k == j){
                        continue;
                    }
                    min = Math.min(dp[i-1][k], min);
                }
                dp[i][j] = costs[i][j] + min;
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < costs[0].length; i++){
            ans = Math.min(dp[costs.length - 1][i], ans);
        }
        return ans;
    }
    
}