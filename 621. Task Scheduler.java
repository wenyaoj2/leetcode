import java.util.*;

class LeastInterval {
    public int leastInterval(char[] tasks, int n) {
        int[] chars = new int[26];
        int num = 0;
        int res = 0;
        Comparator<Character> comparator = new Comparator<Character>() {
            public int compare(Character a, Character b) {
                if(chars[a - 'A'] == chars[b - 'A']) {
                    return a - b;
                }
                return chars[b - 'A'] - chars[a - 'A'];
            }
        };
        for(char c : tasks) {
            chars[c - 'A']++;
        }
        PriorityQueue<Character> pq = new PriorityQueue<Character>(comparator);
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] > 0) {
                num++;
                pq.offer((char)(i + 'A'));
            }
        }
        while(num > 0) {
            int i = 0;
            List<Character> cache = new ArrayList();
            while(i <= n) {
                if(!pq.isEmpty()) {
                    char c = pq.poll();
                    chars[c - 'A']--;
                    if(chars[c - 'A'] == 0) {
                        num--;
                    }
                    else {
                        cache.add(c);
                    }
                }
                res++;
                if(pq.isEmpty() && cache.isEmpty()) {
                    return res;
                }
                i++;
            }
            for(char c : cache) {
                pq.offer(c);
            }
        }
        return res;
    }
}