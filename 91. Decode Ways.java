class NumDecodings {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for(int i = 1; i <= s.length(); i++) {
            if(s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            int num = 0;
            if(i != 1) {
                num = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
            }
            if(num >= 10 && num <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
}