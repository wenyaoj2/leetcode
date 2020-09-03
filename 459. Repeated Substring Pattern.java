class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        for(int i = 0; i < s.length() / 2; i++) {
            String sub = s.substring(0, i + 1);
            if(helper(s, sub)) {
                return true;
            }
        }
        return false;
    }
    private boolean helper(String s, String sub) {
        if(s.length() % sub.length() != 0) {
            return false;
        }
        for(int i = sub.length(); i < s.length(); i++) {
            if(s.charAt(i) != sub.charAt(i % sub.length())) {
                return false;
            }
        }
        return true;
    }
}