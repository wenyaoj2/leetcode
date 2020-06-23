class NumDecodings {
    public int numDecodings(String s) {
        int mod = (int) Math.pow(10, 9) + 7;
        long[] dp = new long[s.length() + 1];
        dp[0] = 1;
        for(int i = 1; i <= s.length(); i++) {
            char c = s.charAt(i - 1);
            if(c == '0') {
                if(i - 1 > 0) { 
                    if(s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2')
                        dp[i] += (dp[i - 2]);
                    else if(s.charAt(i - 2) == '*') {
                        dp[i] += (dp[i - 2]) * 2 ;
                    }
                }
                dp[i] = dp[i] % mod;
                continue;
            }
            if(c == '*') {
                if(i - 1 > 0) { 
                    if(s.charAt(i - 2) == '1')
                        dp[i] += (dp[i - 2]) * 9;
                    else if(s.charAt(i - 2) == '2')
                        dp[i] += (dp[i - 2] ) * 6;
                    else if(s.charAt(i - 2) == '*') 
                        dp[i] += (dp[i - 2]) * 15;
                }
                dp[i] += (dp[i - 1]) * 9;
                dp[i] = dp[i] % mod;
            }
            else {
                if(i - 1 > 0) { 
                    if(s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && c <= '6'))
                        dp[i] += (dp[i - 2]);
                    else if(s.charAt(i - 2) == '*') {
                        if(c <= '6') 
                            dp[i] += (dp[i - 2] ) * 2;
                        else
                            dp[i] += (dp[i - 2]);
                    }
                }
                dp[i] += (dp[i - 1]);
                dp[i] = dp[i] % mod;
            }
        }
        return (int)dp[s.length()];
    }
}