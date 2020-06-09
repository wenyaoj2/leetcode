import java.util.*;

class WordLaddersII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> words = new HashSet(wordList);
        HashMap<String, Integer> hash = new HashMap();
        HashMap<String, HashSet<String>> neighbours = new HashMap();
        int count = bfs(beginWord, endWord, words, hash,  neighbours);
        // System.out.println(count);
        List<List<String>> res = new ArrayList();
        List<String> list = new ArrayList();
        list.add(beginWord);
        dfs(beginWord, endWord, 0, count-1, hash, res, list, neighbours);
        return res;
    }
    public int bfs(String beginWord, String endWord, HashSet<String> words, HashMap<String, Integer> hash, HashMap<String, HashSet<String>> neighbours) {
        Queue<String> queue = new LinkedList();
        hash.put(beginWord,  0);
        queue.offer(beginWord);
        int count = 0;
        boolean flag = false;
        while(!queue.isEmpty()) {
            int len = queue.size();
            count++;
            for(int i = 0; i < len; i++) {
                String cur = queue.poll(); 
                if(cur.equals(endWord)) {
                    flag = true;
                }
                for(String nei : findNeighbours(cur, words)) {
                    neighbours.putIfAbsent(cur, new HashSet());
                    neighbours.get(cur).add(nei);
                    if(hash.containsKey(nei)) {
                        continue;
                    }
                    hash.put(nei, count);
                    queue.offer(nei);
                }
            }
            if(flag) {
                break;
            }
        }
        return count;
    }
    
    public void dfs(String beginWord, String endWord, int count, int target,  HashMap<String, Integer> hash, List<List<String>> res, List<String> list, HashMap<String, HashSet<String>> neighbours) {
        if(count == target && beginWord.equals(endWord)) {
            res.add(new ArrayList(list));
            return;
        }
        if(!neighbours.containsKey(beginWord)) {
            return;
        }
        for(String nei : neighbours.get(beginWord)) {
            if(hash.get(nei) == count + 1) {
                list.add(nei);
                // System.out.println(nei + " " + count);
                dfs(nei, endWord, count + 1, target, hash, res, list, neighbours);
                list.remove(nei);
            }
        }
        return;
    }
    
    public List<String> findNeighbours(String word, HashSet<String> words) {
        List<String> res = new ArrayList();
        for(int i = 0; i < word.length(); i++) {
            char w = word.charAt(i);
            char[] ch = word.toCharArray();
            for(char c = 'a'; c <= 'z'; c++) {
                if(c != w) {
                    ch[i] = c;
                    String s = new String(ch);
                    if(words.contains(s)) {
                        res.add(s);
                    }
                }
            }
        }
        return res;
    }
}