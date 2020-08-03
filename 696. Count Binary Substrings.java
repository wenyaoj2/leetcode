class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        int num0 = 0, num1 = 0;
        int index = 0;
        int res = 0;
        while(index < s.length()) {
            while(index < s.length() && s.charAt(index) == '0') {
                index++;
                num0++;
            }
            res += Math.min(num0, num1);
            num1 = 0;
            while(index < s.length() && s.charAt(index) == '1') {
                index++;
                num1++;
            }
            res += Math.min(num0, num1);
            num0 = 0;
        }
        res += Math.min(num0, num1);
        return res;
    }
}