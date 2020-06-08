import java.util.*;

class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        HashMap<Character, Integer> hash = new HashMap();
        for(int i = 0; i < s.length(); i++) {
            hash.put(s.charAt(i), i);
        }
        Stack<Character> stack = new Stack();
        HashSet<Character> seen = new HashSet();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(seen.contains(c)) {
                continue;
            }
            if(stack.isEmpty() || stack.peek() < c) {
                stack.add(c);
                seen.add(c);
            }
            else {
                while(!stack.isEmpty() && stack.peek() > c && hash.get(stack.peek()) > i) {
                    seen.remove(stack.pop());
                }
                stack.add(c);
                seen.add(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}