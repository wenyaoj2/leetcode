import java.util.*;

class WordSearchII {
    class TrieTree {
        TrieTree[] children = new TrieTree[26];
        char val;
        boolean isWord = false;
        public TrieTree(char val) {
            this.val = val;
        }
    }
    int[] dirA = {0, 0, 1, -1};
    int[] dirB = {1, -1, 0, 0};
    public List<String> findWords(char[][] board, String[] words) {
        TrieTree root = new TrieTree('a');
        for(String word : words) {
            TrieTree cur = root;
            for(char c : word.toCharArray()) {
                if(cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieTree(c);
                }
                cur = cur.children[c - 'a'];
            }
            cur.isWord = true;
        }
        int[][] seen = new int[board.length][board[0].length];
        HashSet<String> res = new HashSet();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                String s = "" + c;
                if(root.children[c - 'a'] != null) {
                    seen[i][j] = 1;
                    helper(board, root.children[c - 'a'], s, res, seen, i, j);
                    seen[i][j] = 0;
                }
            }
        }
        return new ArrayList(res);
    }
    public void helper(char[][] board, TrieTree node, String cur, HashSet<String> res, int[][] seen, int x, int y) {
        if(node.isWord) {
            res.add(cur);
        }
        for(int i = 0; i < dirA.length; i++) {
            int row = x + dirA[i];
            int col = y + dirB[i];
            if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || seen[row][col] == 1 || node.children[board[row][col] - 'a'] == null) {
                continue;
            }
            seen[row][col] = 1;
            helper(board, node.children[board[row][col] - 'a'], cur + board[row][col], res, seen, row, col);
            seen[row][col] = 0;
        }
        return;
    }
}