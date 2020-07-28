import java.util.HashMap;

class MapSum {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        char c;
        int num;
        public TrieNode(char c, int num) {
            this.c = c;
            this.num = num;
        }
    }
    TrieNode root;
    HashMap<String, Integer> seen = new HashMap();
    /** Initialize your data structure here. */
    public MapSum() {
        root = new TrieNode('.', 0);
    }
    
    public void insert(String key, int val) {
        TrieNode node = this.root;
        int prevNum = 0;
        if(seen.containsKey(key)) {
            prevNum = seen.get(key);
        }
        seen.put(key, val);
        for(char c : key.toCharArray()) {
            if(node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode(c, 0);
            }
            node.children[c - 'a'].num += val - prevNum;
            node = node.children[c - 'a'];
            // System.out.println(node.num + " " + node.c);
        }
    }
    
    public int sum(String prefix) {
        TrieNode node = this.root;
        for(char c : prefix.toCharArray()) {
            if(node.children[c - 'a'] == null) {
                return 0;
            }
            node = node.children[c - 'a'];
        }
        return node.num;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */