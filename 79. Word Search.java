class WordSearch {
    int[] dirA = {0, 0, 1, -1};
    int[] dirB = {1, -1, 0, 0};
    public boolean exist(char[][] board, String word) {
        boolean[][] seen = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                char c = word.charAt(0);
                if(board[i][j] == c) {
                    seen[i][j] = true;
                    if(helper(board, seen, 1, word, i, j)) {
                        return true;
                    }
                    seen[i][j] = false;
                }
            }
        }
        return false;
    }
    public boolean helper(char[][] board, boolean[][] seen, int index, String word, int x, int y) {
        if(index == word.length()) {
            return true;
        }
        for(int i = 0; i < dirA.length; i++) {
            int row = x + dirA[i];
            int col = y + dirB[i];
            if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || seen[row][col] || board[row][col] != word.charAt(index)) {
                continue;
            }
            seen[row][col] = true;
            if(helper(board, seen, index + 1, word, row, col)) {
                return true;
            }
            seen[row][col] = false;
        }
        return false;
    }
}