class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int start1 = 0;
        int start2 = 0;
        while(start1 < s.length() && start2 < t.length()) {
            if(t.charAt(start2) == s.charAt(start1)) {
                start1++;
            }
            start2++;
        }
        return start1 == s.length();
    }
}