import java.util.*;

class GeneralizedAbbreviation {
    public List<String> generateAbbreviations(String word) {
        List<String> ans = new ArrayList();
        helper(word, 0, 0, "", ans);
        return ans;
    }
    
    public void helper(String word, int num, int index, String cur, List<String> ans){
        if(index == word.length()){
            if(num == 0){
                ans.add(cur);
                return;
            }
            else{
                cur = cur + num;
                ans.add(cur);
                return;
            }
        }
        helper(word, num+1, index+1, cur, ans);
        if(num == 0){
            helper(word, 0, index+1, cur+word.charAt(index), ans);
        }
        else{
            helper(word, 0, index+1, cur+num+word.charAt(index), ans);
        }
        return;
    }
}