import java.util.*;

class Partition {
    HashMap<Integer, List<List<String>>> hash = new HashMap();
    public List<List<String>> partition(String s) {
        return helper(s, 0);
    }
    private List<List<String>> helper(String s, int index) {
        List<List<String>> ans = new ArrayList();
        if(hash.containsKey(index)) {
            List<List<String>> memo = hash.get(index);
            return memo;
        }
        if(index == s.length()) {
            ans.add(new ArrayList());
            return ans;
        }
        for(int i = index; i < s.length(); i++) {
            String sub = s.substring(index, i + 1);
            if(!isValid(sub)) {
                continue;
            }
            List<List<String>> list = helper(s, i + 1);
            for(List<String> each : list) {
                List<String> temp = new ArrayList();
                temp.add(sub);
                temp.addAll(each);
                ans.add(temp);
            }
        }
        hash.put(index, ans);
        return ans;
    }
    private boolean isValid(String s) {
        int start = 0, end = s.length() - 1;
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}