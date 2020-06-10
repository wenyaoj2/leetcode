class New21Game {
    public double new21Game(int N, int K, int W) {
        if(K == 0) {
            return 1;
        }
        double[] dp = new double[N + 1];
        dp[0] = 1;
        double wsum = 1;
        double res = 0;
        for(int i = 1; i <= N; i++) {
            dp[i] = wsum / W;
            if(i < K) {
                wsum += dp[i];
            }
            else {
                res += dp[i];
            }
            if(i >= W) {
                wsum -= dp[i - W];
            }
        }
        return res;
    }
}