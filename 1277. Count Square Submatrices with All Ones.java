class CountSquares {
    public int countSquares(int[][] matrix) {
        int res = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j];
                    if(dp[i][j] == 1) {
                        res++;
                    }
                    continue;
                }
                if(matrix[i][j] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    res += dp[i][j];
                }
            }
        }
        return res;
    }
}