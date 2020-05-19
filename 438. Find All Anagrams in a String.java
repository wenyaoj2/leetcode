import java.util.*;

class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        if(s.length() < p.length()) {
            return new ArrayList();
        }
        int[] chars = new int[26];
        int[] charp = new int[26];
        List<Integer> res = new ArrayList();
        for(int i = 0; i < p.length(); i++) {
            chars[s.charAt(i) - 'a']++;
            charp[p.charAt(i) - 'a']++;
        }
        for(int i = 0; i < s.length() - p.length(); i++) {
            if(isMatch(chars, charp)) {
                res.add(i);
            }
            chars[s.charAt(i) - 'a']--;
            chars[s.charAt(i + p.length()) - 'a']++;
        }
        if(isMatch(chars, charp)) {
            res.add(s.length() - p.length());
        }
        return res;
    }
    
    public boolean isMatch(int[] chars, int[] charp) {
        for(int i = 0; i < 26; i++) {
            if(chars[i] != charp[i]) {
                return false;
            }
        }
        return true;
    }
}