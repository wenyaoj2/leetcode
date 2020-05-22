class LongestPalindrome {
    public String longestPalindrome(String s) {
        String res = "";
        int max = 0;
        for(int i = 0; i < s.length(); i++) {
            int len1 = helper(s, i, i);
            int len2 = helper(s, i, i + 1);
            if(max < len1) {
                max = len1;
                res = s.substring(i - len1/2, i + len1/2 + 1);
            }
            if(max < len2) {
                max = len2;
                res = s.substring(i - len2/2 + 1, i + len2/2 + 1);
            }
        }
        return res;
    }
    
    public int helper(String s, int i, int j) {
        int start = i;
        int end = j;
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return end - start - 1;
    }
}