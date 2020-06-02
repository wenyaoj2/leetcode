import java.util.*;

class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList();
        HashMap<String, Integer> hash = new HashMap();
        for(int i = 0; i < words.length; i++) {
            hash.put(words[i], i);
        }
        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            String reverseWord = new StringBuilder(word).reverse().toString();
            if(hash.containsKey(reverseWord) && hash.get(reverseWord) != i) {
                res.add(Arrays.asList(i, hash.get(reverseWord)));
            }
            for(String s : findPrefix(word)) {
                if(hash.containsKey(s)) {
                    res.add(Arrays.asList(hash.get(s), i));
                }
            }
            for(String s : findSuffix(word)) {
                if(hash.containsKey(s)) {
                    res.add(Arrays.asList(i, hash.get(s)));
                }
            }
        }
        return res;
    }
    
    public boolean isPalindrome(String word, int start, int end) {
        while(start < end) {
            if(word.charAt(start) != word.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    
    public List<String> findPrefix(String word) {
        List<String> list = new ArrayList();
        for(int i = 0; i < word.length(); i++) {
            if(isPalindrome(word, 0, i)) {
                StringBuilder sb = new StringBuilder(word.substring(i+1, word.length()));
                list.add(sb.reverse().toString());
            }
        }
        return list;
    }
    
    public List<String> findSuffix(String word) {
        List<String> list = new ArrayList();
        for(int i = 0; i < word.length(); i++) {
            if(isPalindrome(word, i, word.length() - 1)) {
                StringBuilder sb = new StringBuilder(word.substring(0, i));
                list.add(sb.reverse().toString());
            }
        }
        return list;
    }
}