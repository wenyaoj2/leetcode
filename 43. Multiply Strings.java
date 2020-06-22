class MultiplyString {
    public String multiply(String num1, String num2) {
        int num = 0;
        int carry = 0;
        int sum = 0;
        StringBuilder cur = new StringBuilder("0");
        for(int i = num1.length() - 1; i >= 0; i--) {
            char a = num1.charAt(i);
            StringBuilder sb = new StringBuilder();
            for(int k = 0; k < num; k++) {
                sb.append(0);
            }
            for(int j = num2.length() - 1; j >= 0; j--) {
                char b = num2.charAt(j);
                sum = (a - '0') * (b - '0') + carry;
                carry = sum / 10;
                sum = sum % 10;
                sb.append(sum);
            }
            if(carry > 0) {
                sb.append(carry);
                carry = 0;
            }
            cur = add(cur, sb.reverse());
            num++;
        }
        StringBuilder res = new StringBuilder();
        for(char c : cur.toString().toCharArray()) {
            if(res.length() == 0 && c == '0') {
                continue;
            }
            else {
                res.append(c);
            }
        } 
        return (res.length() == 0) ? "0" : res.toString();
    }
    public StringBuilder add(StringBuilder num1, StringBuilder num2) {
        StringBuilder sb = new StringBuilder();
        int index1 = num1.length() - 1, index2 = num2.length() - 1;
        int carry = 0, sum = 0;
        while(index1 >= 0 || index2 >= 0) {
            char a = (index1 >= 0) ? num1.charAt(index1) : '0';
            char b = (index2 >= 0) ? num2.charAt(index2) : '0';
            sum = (a - '0') + (b - '0') + carry;
            carry = sum / 10;
            sum = sum % 10;
            index1--;
            index2--;
            sb.append(sum);
        }
        if(carry > 0) {
            sb.append(carry);
        }
        return sb.reverse();
    }
}