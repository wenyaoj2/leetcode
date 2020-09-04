class OpenLock {
    public int openLock(String[] deadends, String target) {
        HashSet<String> dead = new HashSet();
        for(String deadend : deadends) {
            if(deadend.equals("0000")) {
                return -1;
            }
            dead.add(deadend);
        }
        HashSet<String> visited = new HashSet();
        Queue<String> queue = new LinkedList();
        queue.offer("0000");
        visited.add("0000");
        int result = 0;
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                String cur = queue.poll();
                if(cur.equals(target)) {
                    return result;
                }
                for(int j = 0; j < cur.length(); j++) {
                    char[] chars = cur.toCharArray();
                    char c = chars[j];
                    for(int d = -1; d <= 1; d += 2) {
                        char c1 = (char)((c - '0' + d + 10) % 10 + '0');
                        chars[j] = c1;
                        String newString = new String(chars);
                        if(!dead.contains(newString) && !visited.contains(newString)) {
                            visited.add(newString);
                            queue.offer(newString);
                        }
                    }
                }
            }
            result++;
        }
        return -1;
    }
}