class AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int index1 = num1.length() - 1, index2 = num2.length() - 1;
        int carry = 0;
        int sum = 0;
        while(index1 >= 0 || index2 >= 0) {
            int n1 = (index1 >= 0) ? num1.charAt(index1--) - '0' : 0;
            int n2 = (index2 >= 0) ? num2.charAt(index2--) - '0' : 0;
            sum = n1 + n2 + carry;
            carry = sum / 10;
            sb.append(sum % 10);
        }
        if(carry == 1) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}