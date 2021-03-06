class MinDistance {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for(int i = 1; i <= word1.length(); i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }
        for(int i = 1; i <= word2.length(); i++) {
            dp[0][i] = dp[0][i - 1] + 1;
        }
        for(int i = 1; i <= word1.length(); i++) {
            char c1 = word1.charAt(i - 1);
            for(int j = 1; j <= word2.length(); j++) {
                char c2 = word2.charAt(j - 1);
                if(c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1]));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}