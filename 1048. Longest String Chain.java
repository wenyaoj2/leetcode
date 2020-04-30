import java.util.*;
class LongestStringChain{
    class Solution1 {
        public int longestStrChain(String[] words) {
            Comparator<String> comparator = new Comparator<String>(){
                public int compare(String a, String b){
                    return b.length() - a.length();
                }
            };
            int max = 0;
            Arrays.sort(words, comparator);
            HashSet<String> allWords = new HashSet();
            for(String word : words){
                allWords.add(word);
            }
            Queue<String> queue = new LinkedList();
            HashSet<String> hash = new HashSet();
            for(String word : words){
                if(hash.contains(word)){
                    continue;
                }
                queue.offer(word);
                hash.add(word);
                int temp = 0;
                while(!queue.isEmpty()){
                    int size = queue.size();
                    temp++;
                    for(int i = 0; i < size; i++){
                        String cur = queue.poll();
                        for(int j = 0; j < cur.length(); j++){
                            String next = cur.substring(0, j) + cur.substring(j+1, cur.length());
                            // System.out.println(next);
                            if(allWords.contains(next) && !hash.contains(next)){
                            
                                queue.offer(next);
                                hash.add(next);
                            }
                        }
                    }
                }
                max = Math.max(max, temp);
            }
            return max;
        }
    }

    class Solution2 {
        int max = 0;
        public int longestStrChain(String[] words) {
            Comparator<String> comparator = new Comparator<String>(){
                public int compare(String a, String b){
                    return b.length() - a.length();
                }
            };
            Arrays.sort(words, comparator);
            HashSet<String> allWords = new HashSet();
            HashMap<String, Integer> hash = new HashMap();
            for(String word : words){
                allWords.add(word);
            }
            for(String word : words){
                helper(word, allWords, hash);
            }
            return max;
        }
        
        public int helper(String word, HashSet<String> allWords, HashMap<String, Integer> hash){
            if(hash.containsKey(word)){
                return hash.get(word);
            }
            int curMax = 1;
            for(int i = 0; i < word.length(); i++){
                String next = word.substring(0, i) + word.substring(i+1, word.length());
                if(allWords.contains(next)){
                    int temp = 1 + helper(next, allWords, hash);
                    curMax = Math.max(curMax, temp);
                }
            }
            max = Math.max(max, curMax);
            hash.put(word, curMax);
            return curMax;
        }
    }

}