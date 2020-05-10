class IsMatch {
    public boolean isMatch(String s, String p) {
        int[][] visited = new int[s.length() + 1][p.length() + 1];
        return helper(s, 0, p, 0, visited);
    }
    
    public boolean helper(String s, int index1, String p, int index2, int[][]visited) {
        if(index2 == p.length()) {
            return index1 == s.length();
        }
        if(index1 < s.length() && visited[index1][index2] == 1) {
            return false;
        }
        boolean firstMatch = false;
        if(index1 < s.length() && (s.charAt(index1) == p.charAt(index2) || p.charAt(index2) == '.')) {
            firstMatch = true;
        }
        
        if(index2 < p.length() - 1 && p.charAt(index2 + 1) == '*') {
            if(helper(s, index1, p, index2 + 2, visited) || (firstMatch && helper(s, index1 + 1, p, index2, visited))) {
                return true;
            }
        }
        else {
            if(firstMatch && helper(s, index1 + 1, p, index2 + 1, visited)) {
                return true;
            }
        }
        visited[index1][index2] = 1;
        return false;
    }
}