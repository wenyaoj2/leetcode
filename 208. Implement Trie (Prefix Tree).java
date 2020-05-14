class Trie {
    class TrieNode {
        boolean isWord = false;
        TrieNode[] children = new TrieNode[26];
        char val;
        public TrieNode(char val) {
            this.val = val;
        }
    }
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode(' ');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            int num = word.charAt(i) - 'a';
            if(node.children[num] == null) {
                node.children[num] = new TrieNode(word.charAt(i));
            }
            node = node.children[num];
        }
        node.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            int num = word.charAt(i) - 'a';
            if(node.children[num] == null) {
                return false;
            }
            node = node.children[num];
        }
        return node.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(int i = 0; i < prefix.length(); i++) {
            int num = prefix.charAt(i) - 'a';
            if(node.children[num] == null) {
                return false;
            }
            node = node.children[num];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */