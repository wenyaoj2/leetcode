class CheckValidString {
    int[][] seen;
    public boolean checkValidString(String s) {
        seen = new int[s.length() + 1][s.length() + 1];
        return helper(s, 0, 0);
    }
    public boolean helper(String s, int index, int value) {
        if(index == s.length()) {
            return value == 0;
        }
        if(value < 0) {
            return false;
        }
        if(seen[index][value] == 1) {
            return false;
        }
        int cur = value;
        for(int i = index; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                cur++;
            }
            else if(c == ')') {
                cur--;
                if(cur < 0) {
                    seen[index][value] = 1;
                    return false;
                }
            }
            else {
                if(helper(s, i + 1, cur + 1) || helper(s, i + 1, cur) || helper(s, i + 1, cur - 1)) {
                    return true;
                }
                seen[index][value] = 1;
                return false;
            }
        }
        if(cur == 0) {
            return true;
        }
        seen[index][value] = 1;
        return false;
    }
}