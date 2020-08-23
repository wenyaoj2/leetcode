import java.util.*;

class StreamChecker {
    class TrieNode {
        char val;
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
        public TrieNode(char val) {
            this.val = val;
        }
    }
    TrieNode root = new TrieNode('a');
    List<Character> list = new ArrayList();
    public StreamChecker(String[] words) {
        for(String word : words) {
            TrieNode node = this.root;
            for(int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                if(node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode(c);
                }
                node = node.children[c - 'a'];
            }
            node.isEnd = true;
        }
    }
    
    public boolean query(char letter) {
        TrieNode node = this.root;
        list.add(letter);
        for(int i = list.size() - 1; i >= 0; i--) {
            char c = list.get(i);
            if(node.children[c - 'a'] == null) {
                return false;
            }
            if(node.children[c - 'a'].isEnd) {
                return true;
            }
            node = node.children[c - 'a'];
        }
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */