class CustomSortString {
    public String customSortString(String S, String T) {
        int[] chars = new int[26];
        for(char c : T.toCharArray()) {
            chars[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(char c : S.toCharArray()) {
            while(chars[c - 'a'] > 0) {
                sb.append(c);
                chars[c - 'a']--;
            }
        }
        for(int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            while(chars[i] > 0) {
                sb.append(c);
                chars[i]--;
            }
        }
        return sb.toString();
    }
}