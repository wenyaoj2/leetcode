/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        for(int i = 0, x = 0; i < 10 && x < 6; i++) {
            int[] chars = new int[26];
            for(String word : wordlist) {
                for(char c : word.toCharArray()) {
                    chars[c - 'a'] += 1;
                }
            }
            int maxScore = 0;
            String test = "";
            for(String word : wordlist) {
                int curScore = 0;
                for(char c : word.toCharArray()) {
                    curScore += chars[c - 'a'];
                }
                if(curScore > maxScore) {
                    test = word;
                    maxScore = curScore;
                }
            }
            x = master.guess(test);
            List<String> list = new ArrayList();
            for(String word : wordlist) {
                if(x == match(test, word) && test != word) {
                    list.add(word);
                }
            }
            wordlist = list.toArray(new String[0]);
        }
    }
    
    public int match(String a, String b) {
        int score = 0;
        for(int i = 0; i < a.length(); i++) {
            if(a.charAt(i) == b.charAt(i)) {
                score++;
            }
        }
        return score;
    }
}