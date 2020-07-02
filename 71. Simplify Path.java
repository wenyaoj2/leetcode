import java.util.*;

class SimplifyPath {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        Stack<String> stack = new Stack();
        for(String s : paths) {
            if(s.equals("") || s.equals(".")) {
                continue;
            }
            else if(s.equals("..")) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else {
                stack.add(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String s : stack) {
            sb.append("/");
            sb.append(s);
        }
        if(sb.length() == 0) {
            return "/";
        }
        return sb.toString();
    }
}