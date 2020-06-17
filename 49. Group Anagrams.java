import java.util.*;

class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hash = new HashMap();
        for(String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String s = new String(ch);
            hash.putIfAbsent(s, new ArrayList());
            hash.get(s).add(str);
        }
        List<List<String>> res = new ArrayList();
        for(String s : hash.keySet()) {
            res.add(hash.get(s));
        }
        return res;
    }
}