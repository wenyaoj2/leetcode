class TitleToNumber {
    public int titleToNumber(String s) {
        int res = 0;
        for(char c : s.toCharArray()) {
            int num = c - 'A' + 1;
            res = res * 26 + num;
        }
        return res;
    }
}