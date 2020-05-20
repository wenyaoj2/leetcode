class CalculateII {
    public int calculate(String s) {
        int sum = 0;
        int cur = 0;
        int sign = 1;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                cur = cur * 10 + c - '0';
            }
            else if(c == '+') {
                sum += sign * cur;
                sign = 1;
                cur = 0;
            }
            else if(c == '-') {
                sum += sign * cur;
                sign = -1;
                cur = 0;
            }
            else if(c == '*') {
                int nextNum = 0;
                int index = i + 1;
                while(index < s.length() && (s.charAt(index) == ' ' || Character.isDigit(s.charAt(index)))) {
                    if(s.charAt(index) == ' ') {
                        index++;
                        continue;
                    }
                    nextNum = nextNum * 10 + s.charAt(index++) - '0';
                }
                cur = cur * nextNum;
                i = index - 1;
            }
            else if(c == '/') {
                int nextNum = 0;
                int index = i + 1;
                while(index < s.length() && (s.charAt(index) == ' ' || Character.isDigit(s.charAt(index)))) {
                    if(s.charAt(index) == ' ') {
                        index++;
                        continue;
                    }
                    nextNum = nextNum * 10 + s.charAt(index++) - '0';
                }
                cur = cur / nextNum;
                i = index - 1;
            }
        }
        sum += cur * sign;
        return sum;
    }
}