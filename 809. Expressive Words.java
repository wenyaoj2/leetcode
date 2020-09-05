class ExpressiveWords {
    public int expressiveWords(String S, String[] words) {
        if(S.length() == 0) {
            return 0;
        }
        int[] chars = new int[S.length()];
        char c = S.charAt(0);
        int curNum = 0, start = 0;
        int result = 0;
        for(int i = 0; i < S.length();) {
            while(i < S.length() && S.charAt(i) == c) {
                curNum++;
                i++;
            }
            chars[start] = curNum;
            start = i;
            if(i < S.length())
                c = S.charAt(i);
            curNum = 0;
        }
        for(String word : words) {
            if(isValid(word, chars, S)) {
                result++;
            }
        }
        return result;
    }
    private boolean isValid(String word, int[] chars, String s) {
        int index = 0, curNum = 0, index1 = 0;
        char c = word.charAt(0);
        while(index < word.length()) {
            if(index1 > chars.length - 1) {
                return false;
            }
            while(index < word.length() && c == word.charAt(index)) {
                index++;
                curNum++;
            }
            if(c != s.charAt(index1) || curNum > chars[index1] || (chars[index1] < 3 && curNum < chars[index1])) {
                // System.out.println(c + " " + s.charAt(index1) + " " + curNum + " " + chars[index1]);
                return false;
            }
            if(index < word.length())
                c = word.charAt(index);
            index1 += chars[index1];
            curNum = 0;
            
        }
        return index1 == chars.length;
    }
}