import java.util.*;

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack();
        HashSet<Integer> hash = new HashSet();
        for(int i = 0; i < num.length(); i++) {
            if(stack.isEmpty()) {
                stack.add(i);
            }
            else if(num.charAt(stack.peek()) <= num.charAt(i)) {
                stack.add(i);
            }
            else {
                while(!stack.isEmpty() && k > 0 && num.charAt(stack.peek()) > num.charAt(i)) {
                    hash.add(stack.pop());
                    k--;
                }
                stack.add(i);
            }
        }
        
        while(k > 0) {
            hash.add(stack.pop());
            k--;
        }
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for(int i = 0; i < num.length(); i++) {
            if(hash.contains(i) || (!flag && num.charAt(i) == '0')) {
                continue;
            }
            sb.append(num.charAt(i));
            flag = true;
        }
        return sb.toString().equals("")  ? "0" : sb.toString();
    }
}