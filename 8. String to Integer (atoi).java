class MyAtoi {
    public int myAtoi(String str) {
        str = str.trim();
        if(str.equals("")) {
            return 0;
        }
        int symbol = 1;
        int start = 0;
        if(str.charAt(0) == '+') {
            start = 1;
        }
        if(str.charAt(0) == '-') {
            symbol = -1;
            start = 1;
        }
        long num = 0;
        if(start < str.length() && Character.isDigit(str.charAt(start))) {
            while(start < str.length()) {
                char c = str.charAt(start);
                if(Character.isDigit(c)) {
                    num = num*10 + c - '0';
                    if(num > Integer.MAX_VALUE) {
                        return (symbol > 0) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                    }
                }
                else {
                    return (symbol > 0) ? (int) num : (int) (0 -num);
                }
                start++;
            }
            return (symbol > 0) ? (int) num : (int) (0 -num);
        }
        return 0;   
    }
}