class IsOneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        int index1 = 0;
        int index2 = 0;
        while(index1 < s.length() && index2 < t.length()) {
            if(s.charAt(index1) != t.charAt(index2)) {
                break;
            }
            index1++;
            index2++;
        }
        if(index1 < s.length() || index2 < t.length()) {
            return (compare(s, index1 + 1, t, index2 + 1) || compare(s, index1, t, index2 + 1) || compare(s, index1 + 1, t, index2));
        }
        return false;
        
    }
    public boolean compare(String s, int index1, String t, int index2) {
        String subs = (index1 >= s.length()) ? "" : s.substring(index1, s.length());
        String subt = (index2 >= t.length()) ? "" : t.substring(index2, t.length());
        return subs.equals(subt);
    }
}