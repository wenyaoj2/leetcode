import java.util.*;

class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        HashSet<String> hash = new HashSet();
        for(String word : wordDict) {
            hash.add(word);
        }
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < i; j++) {
                // System.out.println(j);
                if(dp[j]) {
                    String sub = s.substring(j, i);
                    if(hash.contains(sub)) {
                        dp[i] = true;
                    }
                }
            }
        }
        return dp[s.length()];
    }
}