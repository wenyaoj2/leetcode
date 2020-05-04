class LastStoneWeightII {
    public int lastStoneWeightII(int[] stones) {
        boolean[] dp = new boolean[3000];
        dp[0] = true;
        int sum = 0;
        for(int stone : stones){
            sum += stone;
            for(int i = Math.min(sum, 1501); i >= stone; i--){
                dp[i] = dp[i] || dp[i - stone];
            }
        }
        for(int i = sum / 2; i >= 0; i--){
            if(dp[i]){
                return sum - i - i;
            }
        }
        return -1;
    }
}