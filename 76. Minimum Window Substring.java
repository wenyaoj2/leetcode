import java.util.*;

class MinWindow {
    public String minWindow(String s, String t) {
        HashSet<Character> visited = new HashSet();
        HashMap<Character, Integer> wordT = new HashMap();
        for(char c : t.toCharArray()) {
            wordT.put(c, wordT.getOrDefault(c, 0) + 1);
        }
        HashMap<Character, Integer> wordS = new HashMap();
        int min = Integer.MAX_VALUE;
        int num = 0;
        int start = 0;
        int end = 0;
        String res = "";
        for(int i = 0; i < s.length(); i++) {
            end = i;
            char c = s.charAt(i);
            if(!wordT.containsKey(c)) {
                continue;
            }
            wordS.putIfAbsent(c, 0);
            wordS.put(c, wordS.get(c) + 1);
            if(!visited.contains(c) && wordS.get(c) >= wordT.get(c)) {
                num++;
                visited.add(c);
            }
            while(num == wordT.keySet().size()) {
                char k = s.charAt(start);
                if(!wordS.containsKey(k)) {
                    start++;
                    continue;
                }
                wordS.put(k, wordS.get(k) - 1);
                if(wordS.get(k) < wordT.get(k)) {
                    num--;
                    visited.remove(k);
                    if(min > end - start + 1) {
                        min = end - start + 1;
                        res = s.substring(start, end + 1);
                    }
                }
                start++;
            }            
        }
        
        return res;
    }
}