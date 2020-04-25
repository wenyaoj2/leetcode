import java.util.*;
class ConcatenatedWords {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Comparator<String> comparator = new Comparator<String>(){
            public int compare(String a, String b){
                return a.length() - b.length();
            }
        };
        Arrays.sort(words, comparator);
        HashSet<String> hash = new HashSet();
        List<String> ans = new ArrayList();
        for(String word : words){
            if(helper(word, hash)){
                ans.add(word);
            }
            hash.add(word);
        }
        return ans;
    }
    
    public boolean helper(String word, HashSet<String> hash){
        if(hash.isEmpty()){
            return false;
        }
        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= word.length(); i++){
            for(int j = 0; j <= i; j++){
                if(dp[j]){
                    String sub = word.substring(j, i);
                    
                    if(hash.contains(sub)){
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[word.length()];
    }
}