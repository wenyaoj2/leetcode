
class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() != s1.length() + s2.length()){
            return false;
        }
        boolean[] dp = new boolean[s2.length()+1];
        dp[0] = true;
        for(int i = 0; i <= s1.length(); i++){
            for(int j = 0; j <= s2.length(); j++){
                if(i == 0 && j == 0){
                    continue;
                }
                if(i == 0){
                    if(s2.charAt(j - 1) == s3.charAt(i + j - 1)){
                        dp[j] = dp[j-1];
                    }
                    else{
                        dp[j] = false;
                    }
                    continue;
                }
                if(j == 0){
                    if(s1.charAt(i - 1) == s3.charAt(i + j - 1)){
                        dp[0] = dp[0];
                    }
                    else{
                        dp[0] = false;
                    }
                    continue;
                }
                dp[j] = (dp[j] && s1.charAt(i-1) == s3.charAt(i+j-1)) || (dp[j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
            }
           
        }
        
         return dp[s2.length()];
    }
}