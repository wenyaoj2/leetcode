class WordDictionary {
    class TrieTree {
        TrieTree[] children = new TrieTree[26];
        char val;
        boolean isWord = false;
        public TrieTree(char val) {
            this.val = val;
        }
    }
    /** Initialize your data structure here. */
    TrieTree root;
    public WordDictionary() {
        root = new TrieTree('l');
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieTree node = root;
        for(char c : word.toCharArray()) {
            if(node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieTree(c);
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        TrieTree node = root;
        return helper(word, 0, node);
    }
    public boolean helper(String word, int index, TrieTree node) {
        if(index == word.length()) {
            return node.isWord;
        }
        char c = word.charAt(index);
        if(c == '.') {
            for(char next = 'a'; next <= 'z'; next++) {
                if(node.children[next - 'a'] == null) {
                    continue;
                }
                if(helper(word, index + 1, node.children[next - 'a'])) {
                    return true;
                }
            }
            return false;
        }
        else {
            if(node.children[c - 'a'] == null) {
                return false;
            }
            return helper(word, index + 1, node.children[c - 'a']);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */