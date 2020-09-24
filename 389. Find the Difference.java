class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character, Integer> hash = new HashMap();
        for(char c : s.toCharArray()) {
            hash.put(c, hash.getOrDefault(c, 0) + 1);
        }
        for(char c : t.toCharArray()) {
            if(!hash.containsKey(c) || hash.get(c) <=0) {
                return c;
            }
            hash.put(c, hash.get(c) - 1);
        }
        return ' ';
    }
}