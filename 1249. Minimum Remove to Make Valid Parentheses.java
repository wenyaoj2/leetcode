import java.util.*;

class MinRemoveToMakeValid {
    public String minRemoveToMakeValid(String s) {
        HashSet<Integer> remove = new HashSet();
        Stack<Integer> stack = new Stack();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.add(i);
            }
            if(s.charAt(i) == ')') {
                if(stack.isEmpty()) {
                    remove.add(i);
                }
                else{
                    stack.pop();
                }
            }
        }
        while(!stack.isEmpty()) {
            remove.add(stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(!remove.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
     }
}