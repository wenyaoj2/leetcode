import java.util.HashMap;

class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hash = new HashMap();
        int res = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            hash.putIfAbsent(c, 0);
            while(hash.get(c) > 0) {
                hash.put(s.charAt(left), hash.get(s.charAt(left)) - 1);
                left++;
            }
            hash.put(c, 1);
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}