import java.util.*;

class ConfusingNumberII {
    HashMap<Character, Character> hash = new HashMap();
    int res = 0;
    public int confusingNumberII(int N) {
        hash.put('0', '0');
        hash.put('1', '1');
        hash.put('6', '9');
        hash.put('9', '6');
        hash.put('8', '8');
        char[] nums = new char[]{'0', '1', '6', '8', '9'};
        for(int i = 1; i < nums.length; i++) {
            String s = "";
            char c = nums[i];
            s = s + c;
            helper(nums, s, N);
        }
        return res;
    }
    public void helper(char[] nums, String cur, int N) {
        if(isDifferent(cur)) {
            res++;
        }
        for(int i = 0; i < nums.length; i++) {
            char c = nums[i];
            if(Long.valueOf(cur + c) > N) {
                break;
            }
            helper(nums, cur + c, N);
        }
        return;
    }
    public boolean isDifferent(String s) {
        int start = 0;
        int end = s.length() - 1;
        while(start <= end) {
            if(hash.get(s.charAt(start)) != s.charAt(end)) {
                return true;
            }
            start++;
            end--;
        }
        return false;
    }
}