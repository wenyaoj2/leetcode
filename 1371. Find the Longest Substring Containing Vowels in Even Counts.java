import java.util.*;

class FindTheLongestSubstring {
    public int findTheLongestSubstring(String s) {
        HashMap<Character, Integer> hash = new HashMap();
        hash.put('a', 1);
        hash.put('e', 2);
        hash.put('i', 4);
        hash.put('o', 8);
        hash.put('u', 32);
        HashMap<Integer, Integer> words = new HashMap();
        int score = 0;
        words.put(score, -1);
        int max = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(hash.containsKey(c)) {
                score ^= hash.get(c);
            }
            words.putIfAbsent(score, i);
            max = Math.max(i - words.get(score), max);
        }
        return max;
    }
}