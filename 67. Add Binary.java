class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        while(i >= 0 || j >= 0) {
            char charA = (i >= 0) ? a.charAt(i) : '0';
            char charB = (j >= 0) ? b.charAt(j) : '0';
            int num = (charA - '0') + (charB - '0') + carry;
            carry = num / 2;
            num = num % 2;
            sb.insert(0, num);
            i--;
            j--;
        }
        if(carry == 1) {
            sb.insert(0, 1);
        }
        return sb.toString();
    }
}