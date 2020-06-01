class CheckInclusionion {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) {
            return false;
        }
        int[] chars1 = new int[26];
        int[] chars2 = new int[26];
        for(int i = 0; i < s1.length(); i++) {
            chars1[s1.charAt(i) - 'a']++;
            chars2[s2.charAt(i) - 'a']++;
        }
        for(int i = s1.length(); i < s2.length(); i++) {
            if(isMatch(chars1, chars2)) {
                return true;
            }
            chars2[s2.charAt(i) - 'a']++;
            chars2[s2.charAt(i - s1.length()) - 'a']--;
        }
        return isMatch(chars1, chars2);
    }
    
    public boolean isMatch(int[] chars1, int[] chars2) {
        for(int i = 0; i < 26; i++) {
            if(chars1[i] != chars2[i]) {
                return false;
            }
        }
        return true;
    }
}