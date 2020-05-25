import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        return helper(s, 0, 4);
    }
    public List<String> helper(String s, int index, int num) {
        List<String> list = new ArrayList();
        if(index == s.length()) {
            return list;
        }
        
        if(num == 1) {
            if(isValid(s.substring(index, s.length()))) {
                list.add(s.substring(index, s.length()));
            }
            return list;
        }
        for(int i = index; i < s.length(); i++) {
            if(!isValid(s.substring(index, i+1))) {
                break;
            }
            String ss = s.substring(index, i+1) + ".";
            List<String> nextLevel = helper(s, i+1, num-1);
            if(nextLevel.size() == 0) {
                continue;
            }
            for(String next : nextLevel) {
                list.add(ss+next);
            }
        }
        return list;
    }
    public boolean isValid(String s) {
        if(s.length() > 3) {
            return false;
        }
        return (s.charAt(0) == '0') ? s.equals("0") : (Integer.valueOf(s) <= 255);
    }
}