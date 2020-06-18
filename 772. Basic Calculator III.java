import java.util.*;

class CalculatorIII {
    public int calculate(String s) {
        Queue<Character> queue = new LinkedList();
        for(char c : s.toCharArray()) {
            queue.offer(c);
        }
        queue.offer('+');
        return helper(queue);
    }
    public int helper(Queue<Character> queue) {
        char symbol = '+';
        Stack<Integer> stack = new Stack();
        int cur = 0;
        while(!queue.isEmpty()) {
            char c = queue.poll();
            if(c == ' ') {
                continue;
            }
            if(Character.isDigit(c)) {
                cur = cur * 10 + c - '0';
            }
            else if(c == '(') {
                cur = helper(queue);
            }
            else {
                if(symbol == '+') {
                    stack.add(cur);
                }
                else if(symbol == '-') {
                    stack.add(-cur);
                }
                else if(symbol == '*') {
                    stack.add(stack.pop() * cur);
                }
                else {
                    stack.add(stack.pop() / cur);
                }
                if(c == ')') {
                    break;
                }
                symbol = c;
                cur = 0;
            }
        }
        int sum = 0;
        while(!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}