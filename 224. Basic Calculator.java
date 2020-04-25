import java.util.Stack;

class BasicCalculator {
    public int calculate(String s) {
        int sum = 0;
        int sign = 1;
        int cur = 0;
        Stack<Integer> stack = new Stack();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                cur = cur*10 + (c - '0');
                continue;
            }
            if(c == '+'){
                sum += sign * cur;
                cur = 0;
                sign = 1;
            }
            else if(c == '-'){
                sum += sign * cur;
                cur = 0;
                sign = -1;
            }
            else if(c == '('){
                stack.add(sum);
                stack.add(sign);
                sum = 0;
                sign = 1;
            }
            else if(c == ')'){
                sum += sign * cur;
                sum = stack.pop() * sum;
                sum += stack.pop();
                cur = 0;
                sign = 1;
            }
            else{
                continue;
            }
        }
        sum += sign * cur;
        return sum;
    }
}