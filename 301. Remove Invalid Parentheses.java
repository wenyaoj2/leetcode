import java.util.*;

class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        HashSet<String> seen = new HashSet();
        List<String> res = new ArrayList();
        Queue<String> queue = new LinkedList();
        queue.offer(s);
        seen.add(s);
        boolean flag = false;
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int k = 0; k < len; k++) {
                String cur = queue.poll();
                if(isValid(cur)) {
                    flag = true;
                    res.add(cur);
                }
                if(flag) {
                    continue;
                }
                for(int i = 0; i < cur.length(); i++) {
                    if(cur.charAt(i) != '(' && cur.charAt(i) != ')') {
                        continue;
                    }
                    String next = cur.substring(0, i) + cur.substring(i + 1, cur.length());
                    if(seen.contains(next)) {
                        continue;
                    }
                    queue.offer(next);
                    seen.add(next);
                }
            }
            if(flag) {
                break;
            }
        }
        return res;
    }
    public boolean isValid(String s) {
        int num = 0;
        for(char c : s.toCharArray()) {
            if(c == '(') {
                num++;
            }
            else if(c == ')') {
                if(num <= 0) {
                    return false;
                }
                num--;
            }
        }
        return num == 0;
    }
}